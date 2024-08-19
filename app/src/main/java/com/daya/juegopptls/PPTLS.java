package com.daya.juegopptls;

import java.util.Random;

public class PPTLS {

    public int CPU;
    public final Random rd = new Random();

    public PPTLS() {
    }

    public int CpuTurno(){
        return rd.nextInt(4);
    }
}
