package com.parkirin.utils;

public interface UrlMapping {
    public static final String OWNER_URL = "/owners";


    //vehicle section-------------------------------------------------
    public static final String VEH_URL = "/vehicles";
    public static  final String TYP_URL = VEH_URL+"/vehicletypes";
    public static  final String BRN_URL = VEH_URL+"/vehiclebrands";



    //parking section-------------------------------------------------
    public static final String PAR_URL = "/parkings";
    public static final String ARE_URL = PAR_URL+"/areas";
    public static final String PT_URL = PAR_URL+"/parkingtypes";
    public static final String PRI_URL = PAR_URL+"/prices";
    public static final String OUT_URL = PAR_URL+"/out";
}
