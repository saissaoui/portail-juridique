package fr.artefrance.daj.ws.test.factory;


import fr.artefrance.daj.domain.rightholder.RightHolderRole;

import java.util.*;

public class RightHolderRoleFactory {

    private static Map<String, String> roles;

    static {
        roles = new HashMap<>();
        roles.put("ACT", "Acteur");
        roles.put("ADA", "Adaptateur");
        roles.put("CD", "Costumier");
        roles.put("EDI", "Editeur");
        roles.put("DG", "Designer");
    }

    private static RightHolderRole createRightHolderRole(String code, String label) {

        RightHolderRole holderRole = new RightHolderRole();
        holderRole.setRoleCode(code);
//        holderRole.setRoleLabel(label);

        return holderRole;
    }

    public static List<RightHolderRole> oneRightHolderRole() {
        return Collections.singletonList(createRightHolderRole("ACT", "Acteur"));
    }

    public static List<RightHolderRole> someRightHolderRole() {
        List<RightHolderRole> rightHolderRoles = new ArrayList<>();
        roles.forEach((key, value) -> {
            RightHolderRole rightHolderRole = new RightHolderRole();
            rightHolderRole.setRoleCode(key);
//            rightHolderRole.setRoleLabel(value);
            rightHolderRoles.add(rightHolderRole);
        });
        return rightHolderRoles;
    }
}
