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

    public static final LatLng ENGLISH_BUILDING = new LatLng(40.107576, -88.228173);

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
                put("Altgeld", ALTGELD);
                put("Architecture Building", ARCHITECTURE);
                put("Armory", ARMORY);
                put("Beckman Institute", BECKMAN);
                put("Business Building", BUSINESS);
                put("Ceramics Building", CERAMICS);
                put("Civil Engineering Lab", CIVIL_ENG_LAB);
                put("Coordinated Science Lab", COORDINATED_SCIENCE_LAB);
                put("David Kinley", DAVID_KINLEY);
                put("Digital Computer Lab", DCL);
                put("ECE Building", ECEB);
                put("Engineering Hall", ENGINEERING_HALL);
                put("English Building", ENGLISH_BUILDING);
                put("Everitt", EVERITT);
                put("Foellinger", FOELLINGER);
                put("Grainger Library", GRAINGER);
                put("Hydro Systems Lab", HYDRO_SYSTEMS_LAB);
                put("Ikenberry (SDRP)", IKENBERRY);
                put("Khan Annex", KHAN_ANNEX);
                put("Lincoln Hall", LINCOLN_HALL);
                put("Loomis", LOOMIS);
                put("Main Library", MAIN_LIBRARY);
                put("Mechanical Engineering", MECHE);
                put("Mechanical Engineering Lab", MEL);
                put("Micro Nano Lab", MICRO_NANO_LAB);
                put("Material Science and Engineering Building", MSEB);
                put("Natural History Building", NATURAL_HISTORY);
                put("NCSA", NCSA);
                put("Noyes", NOYES);
                put("Siebel Center for CS", SIEBEL);
                put("Talbot", TALBOT);
                put("Transportation Building", TRANSPORTATION);
                put("Illini Union", UNION);
                put("Undergraduate Library", UGL);
            }
        };
    }
}