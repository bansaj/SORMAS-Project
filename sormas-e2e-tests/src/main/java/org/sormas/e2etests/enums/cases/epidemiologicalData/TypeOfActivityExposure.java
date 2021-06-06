package org.sormas.e2etests.enums.cases.epidemiologicalData;

public enum TypeOfActivityExposure {
  WORK("Work"),
  TRAVEL("Travel"),
  Sport("Sport"),
  VISIT("Visit"),
  GATHERING("Gathering"),
  Habitation("Habitation"),
  PERSONALSERVICES("Personal Services"),
  BURIAL("Animal Contact"),
  OTHER("Other"),
  UNKNOWN("Unknown");

  private String activity;

  TypeOfActivityExposure(String activity) {
    this.activity = activity;
  }

  public String getActivity() {
    return activity;
  }

  public static TypeOfActivityExposure fromString(String activity) {
    for (TypeOfActivityExposure b : TypeOfActivityExposure.values()) {
      if (b.activity.equalsIgnoreCase(activity)) {
        return b;
      }
    }
    return null;
  }
}
