/*
 * SORMAS® - Surveillance Outbreak Response Management & Analysis System
 * Copyright © 2016-2018 Helmholtz-Zentrum für Infektionsforschung GmbH (HZI)
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package de.symeda.sormas.app.backend.symptoms;

import java.util.List;

import de.symeda.sormas.api.PushResult;
import de.symeda.sormas.api.symptoms.SymptomsDto;
import de.symeda.sormas.app.backend.common.AdoDtoHelper;
import de.symeda.sormas.app.rest.NoConnectionException;
import retrofit2.Call;

/**
 * Created by Martin Wahnschaffe on 27.07.2016.
 */
public class SymptomsDtoHelper extends AdoDtoHelper<Symptoms, SymptomsDto> {

	@Override
	protected Class<Symptoms> getAdoClass() {
		return Symptoms.class;
	}

	@Override
	protected Class<SymptomsDto> getDtoClass() {
		return SymptomsDto.class;
	}

	@Override
	protected Call<List<SymptomsDto>> pullAllSince(long since, Integer size, String lastSynchronizedUuid)  throws NoConnectionException {
		throw new UnsupportedOperationException("Entity is embedded");
	}

	@Override
	protected Call<List<SymptomsDto>> pullByUuids(List<String> uuids) throws NoConnectionException {
		throw new UnsupportedOperationException("Entity is embedded");
	}

	@Override
	protected Call<List<PushResult>> pushAll(List<SymptomsDto> symptomsDtos) throws NoConnectionException {
		throw new UnsupportedOperationException("Entity is embedded");
	}

	@Override
	public void fillInnerFromDto(Symptoms target, SymptomsDto source) {
		target.setAbdominalPain(source.getAbdominalPain());
		target.setAlteredConsciousness(source.getAlteredConsciousness());
		target.setAnorexiaAppetiteLoss(source.getAnorexiaAppetiteLoss());
		target.setBleedingVagina(source.getBleedingVagina());
		target.setBloodInStool(source.getBloodInStool());
		target.setBloodUrine(source.getBloodUrine());
		target.setBloodyBlackStool(source.getBloodyBlackStool());
		target.setChestPain(source.getChestPain());
		target.setConfusedDisoriented(source.getConfusedDisoriented());
		target.setConjunctivitis(source.getConjunctivitis());
		target.setCough(source.getCough());
		target.setCoughingBlood(source.getCoughingBlood());
		target.setDehydration(source.getDehydration());
		target.setDiarrhea(source.getDiarrhea());
		target.setDifficultyBreathing(source.getDifficultyBreathing());
		target.setDigestedBloodVomit(source.getDigestedBloodVomit());
		target.setEyePainLightSensitive(source.getEyePainLightSensitive());
		target.setFatigueWeakness(source.getFatigueWeakness());
		target.setFever(source.getFever());
		target.setGumsBleeding(source.getGumsBleeding());
		target.setHeadache(source.getHeadache());
		target.setHearingloss(source.getHearingloss());
		target.setHiccups(source.getHiccups());
		target.setInjectionSiteBleeding(source.getInjectionSiteBleeding());
		target.setJointPain(source.getJointPain());
		target.setKopliksSpots(source.getKopliksSpots());
		target.setMusclePain(source.getMusclePain());
		target.setNausea(source.getNausea());
		target.setNeckStiffness(source.getNeckStiffness());
		target.setNoseBleeding(source.getNoseBleeding());
		target.setOnsetDate(source.getOnsetDate());
		target.setOnsetSymptom(source.getOnsetSymptom());
		target.setOtherHemorrhagicSymptoms(source.getOtherHemorrhagicSymptoms());
		target.setOtherHemorrhagicSymptomsText(source.getOtherHemorrhagicSymptomsText());
		target.setOtherNonHemorrhagicSymptoms(source.getOtherNonHemorrhagicSymptoms());
		target.setOtherNonHemorrhagicSymptomsText(source.getOtherNonHemorrhagicSymptomsText());
		target.setOtitisMedia(source.getOtitisMedia());
		target.setRedBloodVomit(source.getRedBloodVomit());
		target.setRefusalFeedorDrink(source.getRefusalFeedorDrink());
		target.setRunnyNose(source.getRunnyNose());
		target.setSeizures(source.getSeizures());
		target.setShock(source.getShock());
		target.setSkinBruising(source.getSkinBruising());
		target.setSkinRash(source.getSkinRash());
		target.setSoreThroat(source.getSoreThroat());
		target.setSymptomatic(source.getSymptomatic());
		target.setSymptomsComments(source.getSymptomsComments());
		target.setTemperature(source.getTemperature());
		target.setTemperatureSource(source.getTemperatureSource());
		target.setThrobocytopenia(source.getThrobocytopenia());
		target.setUnexplainedBleeding(source.getUnexplainedBleeding());
		target.setVomiting(source.getVomiting());
		target.setBackache(source.getBackache());
		target.setEyesBleeding(source.getEyesBleeding());
		target.setJaundice(source.getJaundice());
		target.setDarkUrine(source.getDarkUrine());
		target.setStomachBleeding(source.getStomachBleeding());
		target.setRapidBreathing(source.getRapidBreathing());
		target.setSwollenGlands(source.getSwollenGlands());
		target.setLesions(source.getLesions());
		target.setLesionsSameState(source.getLesionsSameState());
		target.setLesionsSameSize(source.getLesionsSameSize());
		target.setLesionsDeepProfound(source.getLesionsDeepProfound());
		target.setLesionsThatItch(source.getLesionsThatItch());
		target.setLesionsFace(source.getLesionsFace());
		target.setLesionsLegs(source.getLesionsLegs());
		target.setLesionsSolesFeet(source.getLesionsSolesFeet());
		target.setLesionsPalmsHands(source.getLesionsPalmsHands());
		target.setLesionsThorax(source.getLesionsThorax());
		target.setLesionsArms(source.getLesionsArms());
		target.setLesionsGenitals(source.getLesionsGenitals());
		target.setLesionsAllOverBody(source.getLesionsAllOverBody());
		target.setLesionsResembleImg1(source.getLesionsResembleImg1());
		target.setLesionsResembleImg2(source.getLesionsResembleImg2());
		target.setLesionsResembleImg3(source.getLesionsResembleImg3());
		target.setLesionsResembleImg4(source.getLesionsResembleImg4());
		target.setLesionsOnsetDate(source.getLesionsOnsetDate());
		target.setLymphadenopathyAxillary(source.getLymphadenopathyAxillary());
		target.setLymphadenopathyCervical(source.getLymphadenopathyCervical());
		target.setLymphadenopathyInguinal(source.getLymphadenopathyInguinal());
		target.setChillsSweats(source.getChillsSweats());
		target.setBedridden(source.getBedridden());
		target.setOralUlcers(source.getOralUlcers());
		target.setPatientIllLocation(source.getPatientIllLocation());
		target.setBlackeningDeathOfTissue(source.getBlackeningDeathOfTissue());
		target.setBuboesGroinArmpitNeck(source.getBuboesGroinArmpitNeck());
		target.setPainfulLymphadenitis(source.getPainfulLymphadenitis());
		target.setBulgingFontanelle(source.getBulgingFontanelle());
		target.setMeningealSigns(source.getMeningealSigns());
		target.setBloodPressureSystolic(source.getBloodPressureSystolic());
		target.setBloodPressureDiastolic(source.getBloodPressureDiastolic());
		target.setHeartRate(source.getHeartRate());
		target.setPharyngealErythema(source.getPharyngealErythema());
		target.setPharyngealExudate(source.getPharyngealExudate());
		target.setOedemaFaceNeck(source.getOedemaFaceNeck());
		target.setOedemaLowerExtremity(source.getOedemaLowerExtremity());
		target.setLossSkinTurgor(source.getLossSkinTurgor());
		target.setPalpableLiver(source.getPalpableLiver());
		target.setPalpableSpleen(source.getPalpableSpleen());
		target.setMalaise(source.getMalaise());
		target.setSunkenEyesFontanelle(source.getSunkenEyesFontanelle());
		target.setSidePain(source.getSidePain());
		target.setFluidInLungCavity(source.getFluidInLungCavity());
		target.setTremor(source.getTremor());
		target.setHemorrhagicSyndrome(source.getHemorrhagicSyndrome());
		target.setHyperglycemia(source.getHyperglycemia());
		target.setHypoglycemia(source.getHypoglycemia());
		target.setSepsis(source.getSepsis());
		target.setMidUpperArmCircumference(source.getMidUpperArmCircumference());
		target.setRespiratoryRate(source.getRespiratoryRate());
		target.setWeight(source.getWeight());
		target.setHeight(source.getHeight());
		target.setGlasgowComaScale(source.getGlasgowComaScale());
		target.setBilateralCataracts(source.getBilateralCataracts());
		target.setUnilateralCataracts(source.getUnilateralCataracts());
		target.setCongenitalGlaucoma(source.getCongenitalGlaucoma());
		target.setCongenitalHeartDisease(source.getCongenitalHeartDisease());
		target.setCongenitalHeartDiseaseType(source.getCongenitalHeartDiseaseType());
		target.setCongenitalHeartDiseaseDetails(source.getCongenitalHeartDiseaseDetails());
		target.setPigmentaryRetinopathy(source.getPigmentaryRetinopathy());
		target.setPurpuricRash(source.getPurpuricRash());
		target.setMicrocephaly(source.getMicrocephaly());
		target.setMeningoencephalitis(source.getMeningoencephalitis());
		target.setDevelopmentalDelay(source.getDevelopmentalDelay());
		target.setSplenomegaly(source.getSplenomegaly());
		target.setJaundiceWithin24HoursOfBirth(source.getJaundiceWithin24HoursOfBirth());
		target.setRadiolucentBoneDisease(source.getRadiolucentBoneDisease());
		target.setHydrophobia(source.getHydrophobia());
		target.setOpisthotonus(source.getOpisthotonus());
		target.setAnxietyStates(source.getAnxietyStates());
		target.setDelirium(source.getDelirium());
		target.setUproariousness(source.getUproariousness());
		target.setParesthesiaAroundWound(source.getParesthesiaAroundWound());
		target.setExcessSalivation(source.getExcessSalivation());
		target.setInsomnia(source.getInsomnia());
		target.setParalysis(source.getParalysis());
		target.setExcitation(source.getExcitation());
		target.setDysphagia(source.getDysphagia());
		target.setAerophobia(source.getAerophobia());
		target.setHyperactivity(source.getHyperactivity());
		target.setParesis(source.getParesis());
		target.setAgitation(source.getAgitation());
		target.setAscendingFlaccidParalysis(source.getAscendingFlaccidParalysis());
		target.setErraticBehaviour(source.getErraticBehaviour());
		target.setComa(source.getComa());
		target.setConvulsion(source.getConvulsion());
		target.setFluidInLungCavityAuscultation(source.getFluidInLungCavityAuscultation());
		target.setFluidInLungCavityXray(source.getFluidInLungCavityXray());
		target.setAbnormalLungXrayFindings(source.getAbnormalLungXrayFindings());
		target.setConjunctivalInjection(source.getConjunctivalInjection());
		target.setAcuteRespiratoryDistressSyndrome(source.getAcuteRespiratoryDistressSyndrome());
		target.setPneumoniaClinicalOrRadiologic(source.getPneumoniaClinicalOrRadiologic());
		target.setLossOfSmell(source.getLossOfSmell());
		target.setLossOfTaste(source.getLossOfTaste());
		target.setCoughWithSputum(source.getCoughWithSputum());
		target.setCoughWithHeamoptysis(source.getCoughWithHeamoptysis());
		target.setLymphadenopathy(source.getLymphadenopathy());
		target.setWheezing(source.getWheezing());
		target.setSkinUlcers(source.getSkinUlcers());
		target.setInabilityToWalk(source.getInabilityToWalk());
		target.setInDrawingOfChestWall(source.getInDrawingOfChestWall());
		target.setOtherComplications(source.getOtherComplications());
		target.setOtherComplicationsText(source.getOtherComplicationsText());
		target.setRespiratoryDiseaseVentilation(source.getRespiratoryDiseaseVentilation());
		target.setFeelingIll(source.getFeelingIll());
		target.setFastHeartRate(source.getFastHeartRate());
		target.setOxygenSaturationLower94(source.getOxygenSaturationLower94());
		target.setFeverishFeeling(source.getFeverishFeeling());
		target.setWeakness(source.getWeakness());
		target.setFatigue(source.getFatigue());
		target.setCoughWithoutSputum(source.getCoughWithoutSputum());
		target.setBreathlessness(source.getBreathlessness());
		target.setChestPressure(source.getChestPressure());
		target.setBlueLips(source.getBlueLips());
		target.setBloodCirculationProblems(source.getBloodCirculationProblems());
		target.setPalpitations(source.getPalpitations());
		target.setDizzinessStandingUp(source.getDizzinessStandingUp());
		target.setHighOrLowBloodPressure(source.getHighOrLowBloodPressure());
		target.setUrinaryRetention(source.getUrinaryRetention());
		target.setShivering(source.getShivering());

		target.setPseudonymized(source.isPseudonymized());
	}

	@Override
	public void fillInnerFromAdo(SymptomsDto target, Symptoms source) {
		target.setAbdominalPain(source.getAbdominalPain());
		target.setAlteredConsciousness(source.getAlteredConsciousness());
		target.setAnorexiaAppetiteLoss(source.getAnorexiaAppetiteLoss());
		target.setBleedingVagina(source.getBleedingVagina());
		target.setBloodInStool(source.getBloodInStool());
		target.setBloodUrine(source.getBloodUrine());
		target.setBloodyBlackStool(source.getBloodyBlackStool());
		target.setChestPain(source.getChestPain());
		target.setConfusedDisoriented(source.getConfusedDisoriented());
		target.setConjunctivitis(source.getConjunctivitis());
		target.setCough(source.getCough());
		target.setCoughingBlood(source.getCoughingBlood());
		target.setDehydration(source.getDehydration());
		target.setDiarrhea(source.getDiarrhea());
		target.setDifficultyBreathing(source.getDifficultyBreathing());
		target.setDigestedBloodVomit(source.getDigestedBloodVomit());
		target.setEyePainLightSensitive(source.getEyePainLightSensitive());
		target.setFatigueWeakness(source.getFatigueWeakness());
		target.setFever(source.getFever());
		target.setGumsBleeding(source.getGumsBleeding());
		target.setHeadache(source.getHeadache());
		target.setHearingloss(source.getHearingloss());
		target.setHiccups(source.getHiccups());
		target.setInjectionSiteBleeding(source.getInjectionSiteBleeding());
		target.setJointPain(source.getJointPain());
		target.setKopliksSpots(source.getKopliksSpots());
		target.setMusclePain(source.getMusclePain());
		target.setNausea(source.getNausea());
		target.setNeckStiffness(source.getNeckStiffness());
		target.setNoseBleeding(source.getNoseBleeding());
		target.setOnsetDate(source.getOnsetDate());
		target.setOnsetSymptom(source.getOnsetSymptom());
		target.setOtherHemorrhagicSymptoms(source.getOtherHemorrhagicSymptoms());
		target.setOtherHemorrhagicSymptomsText(source.getOtherHemorrhagicSymptomsText());
		target.setOtherNonHemorrhagicSymptoms(source.getOtherNonHemorrhagicSymptoms());
		target.setOtherNonHemorrhagicSymptomsText(source.getOtherNonHemorrhagicSymptomsText());
		target.setOtitisMedia(source.getOtitisMedia());
		target.setRedBloodVomit(source.getRedBloodVomit());
		target.setRefusalFeedorDrink(source.getRefusalFeedorDrink());
		target.setRunnyNose(source.getRunnyNose());
		target.setSeizures(source.getSeizures());
		target.setShock(source.getShock());
		target.setSkinBruising(source.getSkinBruising());
		target.setSkinRash(source.getSkinRash());
		target.setSoreThroat(source.getSoreThroat());
		target.setSymptomatic(source.getSymptomatic());
		target.setSymptomsComments(source.getSymptomsComments());
		target.setTemperature(source.getTemperature());
		target.setTemperatureSource(source.getTemperatureSource());
		target.setThrobocytopenia(source.getThrobocytopenia());
		target.setUnexplainedBleeding(source.getUnexplainedBleeding());
		target.setVomiting(source.getVomiting());
		target.setBackache(source.getBackache());
		target.setEyesBleeding(source.getEyesBleeding());
		target.setJaundice(source.getJaundice());
		target.setDarkUrine(source.getDarkUrine());
		target.setStomachBleeding(source.getStomachBleeding());
		target.setRapidBreathing(source.getRapidBreathing());
		target.setSwollenGlands(source.getSwollenGlands());
		target.setLesions(source.getLesions());
		target.setLesionsSameState(source.getLesionsSameState());
		target.setLesionsSameSize(source.getLesionsSameSize());
		target.setLesionsDeepProfound(source.getLesionsDeepProfound());
		target.setLesionsThatItch(source.getLesionsThatItch());
		target.setLesionsFace(source.getLesionsFace());
		target.setLesionsLegs(source.getLesionsLegs());
		target.setLesionsSolesFeet(source.getLesionsSolesFeet());
		target.setLesionsPalmsHands(source.getLesionsPalmsHands());
		target.setLesionsThorax(source.getLesionsThorax());
		target.setLesionsArms(source.getLesionsArms());
		target.setLesionsGenitals(source.getLesionsGenitals());
		target.setLesionsAllOverBody(source.getLesionsAllOverBody());
		target.setLesionsResembleImg1(source.getLesionsResembleImg1());
		target.setLesionsResembleImg2(source.getLesionsResembleImg2());
		target.setLesionsResembleImg3(source.getLesionsResembleImg3());
		target.setLesionsResembleImg4(source.getLesionsResembleImg4());
		target.setLesionsOnsetDate(source.getLesionsOnsetDate());
		target.setLymphadenopathyAxillary(source.getLymphadenopathyAxillary());
		target.setLymphadenopathyCervical(source.getLymphadenopathyCervical());
		target.setLymphadenopathyInguinal(source.getLymphadenopathyInguinal());
		target.setChillsSweats(source.getChillsSweats());
		target.setBedridden(source.getBedridden());
		target.setOralUlcers(source.getOralUlcers());
		target.setPatientIllLocation(source.getPatientIllLocation());
		target.setBlackeningDeathOfTissue(source.getBlackeningDeathOfTissue());
		target.setBuboesGroinArmpitNeck(source.getBuboesGroinArmpitNeck());
		target.setPainfulLymphadenitis(source.getPainfulLymphadenitis());
		target.setBulgingFontanelle(source.getBulgingFontanelle());
		target.setMeningealSigns(source.getMeningealSigns());
		target.setBloodPressureSystolic(source.getBloodPressureSystolic());
		target.setBloodPressureDiastolic(source.getBloodPressureDiastolic());
		target.setHeartRate(source.getHeartRate());
		target.setPharyngealErythema(source.getPharyngealErythema());
		target.setPharyngealExudate(source.getPharyngealExudate());
		target.setOedemaFaceNeck(source.getOedemaFaceNeck());
		target.setOedemaLowerExtremity(source.getOedemaLowerExtremity());
		target.setLossSkinTurgor(source.getLossSkinTurgor());
		target.setPalpableLiver(source.getPalpableLiver());
		target.setPalpableSpleen(source.getPalpableSpleen());
		target.setMalaise(source.getMalaise());
		target.setSunkenEyesFontanelle(source.getSunkenEyesFontanelle());
		target.setSidePain(source.getSidePain());
		target.setFluidInLungCavity(source.getFluidInLungCavity());
		target.setTremor(source.getTremor());
		target.setHemorrhagicSyndrome(source.getHemorrhagicSyndrome());
		target.setHyperglycemia(source.getHyperglycemia());
		target.setHypoglycemia(source.getHypoglycemia());
		target.setSepsis(source.getSepsis());
		target.setMidUpperArmCircumference(source.getMidUpperArmCircumference());
		target.setRespiratoryRate(source.getRespiratoryRate());
		target.setWeight(source.getWeight());
		target.setHeight(source.getHeight());
		target.setGlasgowComaScale(source.getGlasgowComaScale());
		target.setBilateralCataracts(source.getBilateralCataracts());
		target.setUnilateralCataracts(source.getUnilateralCataracts());
		target.setCongenitalGlaucoma(source.getCongenitalGlaucoma());
		target.setCongenitalHeartDisease(source.getCongenitalHeartDisease());
		target.setCongenitalHeartDiseaseType(source.getCongenitalHeartDiseaseType());
		target.setCongenitalHeartDiseaseDetails(source.getCongenitalHeartDiseaseDetails());
		target.setPigmentaryRetinopathy(source.getPigmentaryRetinopathy());
		target.setPurpuricRash(source.getPurpuricRash());
		target.setMicrocephaly(source.getMicrocephaly());
		target.setMeningoencephalitis(source.getMeningoencephalitis());
		target.setDevelopmentalDelay(source.getDevelopmentalDelay());
		target.setSplenomegaly(source.getSplenomegaly());
		target.setJaundiceWithin24HoursOfBirth(source.getJaundiceWithin24HoursOfBirth());
		target.setRadiolucentBoneDisease(source.getRadiolucentBoneDisease());
		target.setHydrophobia(source.getHydrophobia());
		target.setOpisthotonus(source.getOpisthotonus());
		target.setAnxietyStates(source.getAnxietyStates());
		target.setDelirium(source.getDelirium());
		target.setUproariousness(source.getUproariousness());
		target.setParesthesiaAroundWound(source.getParesthesiaAroundWound());
		target.setExcessSalivation(source.getExcessSalivation());
		target.setInsomnia(source.getInsomnia());
		target.setParalysis(source.getParalysis());
		target.setExcitation(source.getExcitation());
		target.setDysphagia(source.getDysphagia());
		target.setAerophobia(source.getAerophobia());
		target.setHyperactivity(source.getHyperactivity());
		target.setParesis(source.getParesis());
		target.setAgitation(source.getAgitation());
		target.setAscendingFlaccidParalysis(source.getAscendingFlaccidParalysis());
		target.setErraticBehaviour(source.getErraticBehaviour());
		target.setComa(source.getComa());
		target.setConvulsion(source.getConvulsion());
		target.setFluidInLungCavityAuscultation(source.getFluidInLungCavityAuscultation());
		target.setFluidInLungCavityXray(source.getFluidInLungCavityXray());
		target.setAbnormalLungXrayFindings(source.getAbnormalLungXrayFindings());
		target.setConjunctivalInjection(source.getConjunctivalInjection());
		target.setAcuteRespiratoryDistressSyndrome(source.getAcuteRespiratoryDistressSyndrome());
		target.setPneumoniaClinicalOrRadiologic(source.getPneumoniaClinicalOrRadiologic());
		target.setLossOfSmell(source.getLossOfSmell());
		target.setLossOfTaste(source.getLossOfTaste());
		target.setCoughWithSputum(source.getCoughWithSputum());
		target.setCoughWithHeamoptysis(source.getCoughWithHeamoptysis());
		target.setLymphadenopathy(source.getLymphadenopathy());
		target.setWheezing(source.getWheezing());
		target.setSkinUlcers(source.getSkinUlcers());
		target.setInabilityToWalk(source.getInabilityToWalk());
		target.setInDrawingOfChestWall(source.getInDrawingOfChestWall());
		target.setOtherComplications(source.getOtherComplications());
		target.setOtherComplicationsText(source.getOtherComplicationsText());
		target.setRespiratoryDiseaseVentilation(source.getRespiratoryDiseaseVentilation());
		target.setFeelingIll(source.getFeelingIll());
		target.setFastHeartRate(source.getFastHeartRate());
		target.setOxygenSaturationLower94(source.getOxygenSaturationLower94());
		target.setFeverishFeeling(source.getFeverishFeeling());
		target.setWeakness(source.getWeakness());
		target.setFatigue(source.getFatigue());
		target.setCoughWithoutSputum(source.getCoughWithoutSputum());
		target.setBreathlessness(source.getBreathlessness());
		target.setChestPressure(source.getChestPressure());
		target.setBlueLips(source.getBlueLips());
		target.setBloodCirculationProblems(source.getBloodCirculationProblems());
		target.setPalpitations(source.getPalpitations());
		target.setDizzinessStandingUp(source.getDizzinessStandingUp());
		target.setHighOrLowBloodPressure(source.getHighOrLowBloodPressure());
		target.setUrinaryRetention(source.getUrinaryRetention());
		target.setShivering(source.getShivering());

		target.setPseudonymized(source.isPseudonymized());
	}

    @Override
    protected long getApproximateJsonSizeInBytes() {
        return 0;
    }
}
