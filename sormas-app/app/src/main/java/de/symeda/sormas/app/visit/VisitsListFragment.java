package de.symeda.sormas.app.visit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;

import de.symeda.sormas.app.R;
import de.symeda.sormas.app.backend.common.DatabaseHelper;
import de.symeda.sormas.app.backend.contact.Contact;
import de.symeda.sormas.app.backend.visit.Visit;
import de.symeda.sormas.app.util.Callback;
import de.symeda.sormas.app.util.ConnectionHelper;
import de.symeda.sormas.app.util.SyncCallback;

public class VisitsListFragment extends ListFragment {

    public static final String KEY_CONTACT_UUID = "contactUuid";

    private String contactUuid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        updateArrayAdapter();
    }

    public void updateArrayAdapter() {
        contactUuid = getArguments().getString(Contact.UUID);
        final Contact contact = DatabaseHelper.getContactDao().queryUuid(contactUuid);
        syncVisits(contact);

        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swiperefresh);
        if (refreshLayout != null) {
            refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    if (ConnectionHelper.isConnectedToInternet(getContext())) {
                        SyncVisitsTask.syncVisitsWithCallback(getContext(), getActivity().getSupportFragmentManager(), new SyncCallback() {
                            @Override
                            public void call(boolean syncFailed) {
                                refreshLayout.setRefreshing(false);
                                if (!syncFailed) {
                                    Toast.makeText(getContext(), "Synchronization successful.", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getContext(), "Synchronization failed. Please try again later. This error has automatically been reported.", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    } else {
                        refreshLayout.setRefreshing(false);
                        Toast.makeText(getContext(), "You are not connected to the internet.", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        VisitsListArrayAdapter adapter = new VisitsListArrayAdapter(
                this.getActivity(),             // Context for the activity.
                R.layout.visits_list_item);     // Layout to use (create)

        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> parent,
                    View viewClicked,
                    int position, long id) {
                Visit visit = (Visit) getListAdapter().getItem(position);
                showVisitEditView(visit);
            }
        });
    }

    public void showVisitEditView(Visit visit) {
        Intent intent = new Intent(getActivity(), VisitEditActivity.class);
        intent.putExtra(Visit.UUID, visit.getUuid());
        intent.putExtra(KEY_CONTACT_UUID, contactUuid);
        startActivity(intent);
    }

    private void syncVisits(final Contact contact) {
        List<Visit> visits = DatabaseHelper.getVisitDao().getByContact(contact);
        ArrayAdapter<Visit> listAdapter = (ArrayAdapter<Visit>)getListAdapter();
        listAdapter.clear();
        listAdapter.addAll(visits);

        if (listAdapter.getCount() == 0) {
            getView().findViewById(R.id.empty_list_hint).setVisibility(View.VISIBLE);
            getView().findViewById(android.R.id.list).setVisibility(View.GONE);
        } else {
            getView().findViewById(R.id.empty_list_hint).setVisibility(View.GONE);
            getView().findViewById(android.R.id.list).setVisibility(View.VISIBLE);
        }
    }

}
