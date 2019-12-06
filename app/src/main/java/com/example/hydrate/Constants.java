package com.example.hydrate;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds coordinates of buildings as LatLng objects.
 */
@SuppressWarnings({"WeakerAccess", "SpellCheckingInspection"})
class BuildingLatLng {

    public static final LatLng ALTGELD = new LatLng(40.109357, -88.228349);

    public static final LatLng ARCHITECTURE = new LatLng(40.103265, -88.229088);

    public static final LatLng ARMORY = new LatLng(40.104799, -88.231952);

    public static final LatLng BECKMAN = new LatLng(40.115797, -88.227208);

    public static final LatLng BUSINESS = new LatLng(40.103872, -88.230928);

    public static final LatLng CERAMICS = new LatLng(40.111789, -88.224270);

    public static final LatLng CIVIL_ENG_LAB = new LatLng(40.113980, -88.226564);

    public static final LatLng COORDINATED_SCIENCE_LAB = new LatLng(40.114887, -88.226725);

    public static final LatLng DAVID_KINLEY = new LatLng(40.103638, -88.228353);

    public static final LatLng DCL = new LatLng(40.113139, -88.226564);

    public static final LatLng ECEB = new LatLng(40.114899, -88.228013);

    public static final LatLng ENGINEERING_HALL = new LatLng(40.1108, -88.2270);

    public static final LatLng ENGLISH = new LatLng(40.107576, -88.228173);

    public static final LatLng EVERITT = new LatLng(40.1109, -88.2283);

    public static final LatLng FOELLINGER = new LatLng(40.105932, -88.227188);

    public static final LatLng GRAINGER = new LatLng(40.1125, -88.2269);

    public static final LatLng HYDRO_SYSTEMS_LAB = new LatLng(40.114829, -88.226076);

    public static final LatLng IKENBERRY = new LatLng(40.103745, -88.235160);

    public static final LatLng KHAN_ANNEX = new LatLng(40.103925, -88.232623);

    public static final LatLng LINCOLN_HALL = new LatLng(40.106620, -88.228222);

    public static final LatLng LOOMIS = new LatLng(40.110966, -88.223342);

    public static final LatLng MAIN_LIBRARY = new LatLng(40.104779, -88.228734);

    public static final LatLng MECHE = new LatLng(40.111063, -88.225131);

    public static final LatLng MEL = new LatLng(40.111995, -88.226119);

    public static final LatLng MICRO_NANO_LAB = new LatLng(40.113857, -88.227894);

    public static final LatLng MSEB = new LatLng(40.111015, -88.226100);

    public static final LatLng NATURAL_HISTORY = new LatLng(40.1094, -88.2260);

    public static final LatLng NCSA = new LatLng(40.114928, -88.224864);

    public static final LatLng NOYES = new LatLng(40.108462, -88.226113);

    public static final LatLng SIEBEL = new LatLng(40.113820, -88.224906);

    public static final LatLng TALBOT = new LatLng(40.111941, -88.228238);

    public static final LatLng TRANSPORTATION = new LatLng(40.111757, -88.225201);

    public static final LatLng UNION = new LatLng(40.1092, -88.2272);

    public static final LatLng UGL = new LatLng(40.104691, -88.227180);

    public static Map<String, LatLng> getNameMap() {
        return new HashMap<String, LatLng>() {
            {
                put("ALTGELD", ALTGELD);
                put("ARCHITECTURE", ARCHITECTURE);
                put("ARMORY", ARMORY);
                put("BECKMAN", BECKMAN);
                put("BUSINESS", BUSINESS);
                put("CERAMICS", CERAMICS);
                put("CIVIL_ENG_LAB", CIVIL_ENG_LAB);
                put("COORDINATED_SCIENCE_LAB", COORDINATED_SCIENCE_LAB);
                put("DAVID_KINLEY", DAVID_KINLEY);
                put("DCL", DCL);
                put("ECEB", ECEB);
                put("ENGINEERING_HALL", ENGINEERING_HALL);
                put("ENGLISH", ENGLISH);
                put("EVERITT", EVERITT);
                put("FOELLINGER", FOELLINGER);
                put("GRAINGER", GRAINGER);
                put("HYDRO_SYSTEMS_LAB", HYDRO_SYSTEMS_LAB);
                put("IKENBERRY", IKENBERRY);
                put("KHAN_ANNEX", KHAN_ANNEX);
                put("LINCOLN_HALL", LINCOLN_HALL);
                put("LOOMIS", LOOMIS);
                put("MAIN_LIBRARY", MAIN_LIBRARY);
                put("MECHE", MECHE);
                put("MEL", MEL);
                put("MICRO_NANO_LAB", MICRO_NANO_LAB);
                put("MSEB", MSEB);
                put("NATURAL_HISTORY", NATURAL_HISTORY);
                put("NCSA", NCSA);
                put("NOYES", NOYES);
                put("SIEBEL", SIEBEL);
                put("TALBOT", TALBOT);
                put("TRANSPORTATION", TRANSPORTATION);
                put("UNION", UNION);
                put("UGL", UGL);
            }
        };
    }
    public static Map<String, Double> getDisplayNamesAndRatings() {
        return new HashMap<String, Double>() {
            {
                put("Altgeld", 0.0);
                put("Architecture Building", 0.0);
                put("Armory", 0.0);
                put("Beckman Institute", 0.0);
                put("Business Instructional Facility",0.0);
                put("Ceramics Building",0.0);
                put("Civil Engineering Lab",0.0);
                put("Coordinated Science Lab",0.0);
                put("David Kinley Hall",0.0);
                put("Digital Computing Lab",0.0);
                put("Electrical and Computer Engineering Building", 0.0);
                put("Engineering Hall", 0.0);
            }

        };
    }
}