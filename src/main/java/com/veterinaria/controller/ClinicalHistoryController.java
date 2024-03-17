package com.veterinaria.controller;

import com.veterinaria.connectionDB.ActionsDB;
import com.veterinaria.model.ClinicalHistory;

import java.util.List;
import java.util.Set;

public class ClinicalHistoryController {
    private Set<ClinicalHistoryController> listOfClinicalHistory;
    private ClinicalHistory clHistory = new ClinicalHistory();
    private ActionsDB actionsDB = new ActionsDB();
    public ClinicalHistoryController() {
        List<String> data = actionsDB.selectAll("historia");
        System.out.println(data);
    }

    public Set<ClinicalHistoryController> getAllClinicalHistory() {
        return listOfClinicalHistory;
    }

    public ClinicalHistoryController findClinicalHistoryByID(int id) {
        for (ClinicalHistoryController clinicalHistory : listOfClinicalHistory) {
            if (clHistory.getDate() == id) {
                return clinicalHistory;
            }
        }
        return null;
    }

    public void saveClHistory(ClinicalHistory clinicalHistory) {
        // Guardar en la base de datos tabla, [columnas], [valores]
        ActionsDB.insert("historia", new String[]{"fecha", "veterinario", "motivo", "sintomas", "diagnostico", "procedimiento", "medicamento", "dosis", "idOrden", "alergia", "detalleProcedimiento", "cancelacionOrden"}, new String[]{String.valueOf(clHistory.getDate()), String.valueOf(clHistory.getVeterinarian()), clHistory.getReason(), clHistory.getSymptoms(), clHistory.getDiagnosis(), clHistory.getProcedure(), clHistory.getMedication(), clHistory.getDose(), clHistory.getIdOrder(), clHistory.getAllergy(), clHistory.getProcedureDetail(), String.valueOf(clHistory.isOrderCancellation())});
    }

}
