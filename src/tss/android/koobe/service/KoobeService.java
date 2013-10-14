package tss.android.koobe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tss.android.koobe.model.Environment;
import tss.android.koobe.model.Equipment;
import tss.android.koobe.model.Type;
import tss.android.koobe.model.Type.EquipmentType;

public class KoobeService {

    private static KoobeService                 mInstance;

    private List<Environment>                   mEnvironments;
    private List<Equipment>                     mEquipments;

    private Map<Long, List<Equipment>>          mEnvironmentsMap;
    private Map<EquipmentType, List<Equipment>> mEquipmentsTypeMap;

    private KoobeService() {
        loadUserData("", "");
    }

    public static KoobeService getInstance() {
        if (mInstance == null) {
            mInstance = new KoobeService();
        }
        return mInstance;
    }

    public List<Environment> getEnviromentList() {
        return mEnvironments;
    }

    public List<Equipment> getEquipments() {
        return mEquipments;
    }

    public void loadUserData(String user, String token) {

        // TODO *********** FAKE DATA: ENVIROMENTS ***********

        mEnvironments = new ArrayList<Environment>();
        mEnvironments.add(new Environment(1, "Quarto casal"));
        mEnvironments.add(new Environment(2, "Quarto crianças"));
        mEnvironments.add(new Environment(3, "Quarto hóspede"));
        mEnvironments.add(new Environment(4, "Cozinha"));
        mEnvironments.add(new Environment(5, "Garagem"));
        mEnvironments.add(new Environment(6, "Varanda"));
        mEnvironments.add(new Environment(7, "Área de serviço"));

        // TODO *********** FAKE DATA: EQUIPMENTS ***********

        mEquipments = new ArrayList<Equipment>();
        mEquipments.add(new Equipment("Lampada Qt. Casal", EquipmentType.LAMP, 1));
        mEquipments.add(new Equipment("Lampada da Suíte", EquipmentType.LAMP, 1));
        mEquipments.add(new Equipment("Ar Condicionado Casal", EquipmentType.AIR_CONDITIONER, 1));
        mEquipments.add(new Equipment("Abaju Casal", EquipmentType.ADJUSTABLE_LAMP, 1));
        mEquipments.add(new Equipment("Tv Casal", EquipmentType.TV_CONTROL, 1));

        mEquipments.add(new Equipment("Lampada Qt. Crianças", EquipmentType.LAMP, 2));
        mEquipments.add(new Equipment("Ar Condicionado Crianças", EquipmentType.AIR_CONDITIONER, 2));
        mEquipments.add(new Equipment("Tv Crianças", EquipmentType.TV_CONTROL, 2));

        mEquipments.add(new Equipment("Lampada Qt. Hóspedes", EquipmentType.LAMP, 3));
        mEquipments.add(new Equipment("Ar Condicionado Hóspedes", EquipmentType.AIR_CONDITIONER, 3));

        mEquipments.add(new Equipment("Lampada Cozinha", EquipmentType.LAMP, 4));
        mEquipments.add(new Equipment("Tv Cozinha", EquipmentType.TV_CONTROL, 4));

        mEquipments.add(new Equipment("Lampada Garagem", EquipmentType.LAMP, 5));

        mEquipments.add(new Equipment("Lampada Varanda", EquipmentType.LAMP, 6));

        mEquipments.add(new Equipment("Lampada Serviço", EquipmentType.LAMP, 7));

        mEnvironmentsMap = new HashMap<Long, List<Equipment>>();
        mEquipmentsTypeMap = new HashMap<Type.EquipmentType, List<Equipment>>();

        for (Environment enviroment : mEnvironments) {

            List<Equipment> value = new ArrayList<Equipment>();
            for (int i = 0; i < mEquipments.size(); i++) {
                Equipment eq = mEquipments.get(i);
                if (eq.getEnvironmentId() == enviroment.getId()) {
                    value.add(eq);
                }
            }
            mEnvironmentsMap.put(enviroment.getId(), value);
        }

        for (EquipmentType type : EquipmentType.values()) {

            List<Equipment> value = new ArrayList<Equipment>();
            for (int i = 0; i < mEquipments.size(); i++) {
                Equipment eq = mEquipments.get(i);
                if (eq.getType() == type) {
                    value.add(eq);
                }
            }
            mEquipmentsTypeMap.put(type, value);
        }

    }

    public List<Equipment> getEquipmentsByEnviroment(long enviromentId) {
        return mEnvironmentsMap.get(enviromentId);
    }

    public List<Equipment> getEquipmentsByType(EquipmentType type) {
        return mEquipmentsTypeMap.get(type);
    }

    public int[] getTypeList() {
        return Type.getTypeList();
    }

}
