package com.example.index.Models;

import android.util.Log;

import com.example.index.Config;
import com.example.index.Models.Enums.EnumIndex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Shifr {

    private static final String TAG = "ExampleInstrumentedTest";

    private final int offerid;
    private final int zCoin;
    private final String DateStart;
    private final String DateEnd;
    private final int tickID;
    private final int kindTick;


    public static class Builder {

        private int offerid;
        private int zCoin;
        private String DateStart;
        private String DateEnd;
        private int tickID;
        private int kindTick;

        public Builder() {
        }
        public Builder set_offerid(int val){
            this.offerid = val;
            return this;
        }
        public Builder set_zCoin(int val){
            this.zCoin = val;
            return this;
        }
        public Builder set_DateStart(String val){
            this.DateStart = val;
            return this;
        }
        public Builder set_DateEnd(String val){
            this.DateEnd = val;
            return this;
        }
        public Builder set_TickID(int val){
            this.tickID = val;
            return this;
        }
        public Builder set_TickKind(int val){
            this.kindTick = val;
            return this;
        }


        public Shifr build(){
            return new Shifr(this);
        }
    }

    private Shifr(Builder builder) {
        offerid = builder.offerid;
        zCoin = builder.zCoin;
        DateStart = builder.DateStart;
        DateEnd = builder.DateEnd;
        tickID = builder.tickID;
        kindTick = builder.kindTick;
    }

    public String base64_shifr(EnumIndex enumIndex){
        // шиврование
        String base64 = "";
        try{

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String r = "";
            if (enumIndex == EnumIndex.OFFERDELETE){			//удаление заявки
                r = Config.LOGIN+ ';' + Config.PASSWORD+ ';' + Config.CULTURE+ ';' + Config.WMID + ';' + offerid;
            }
            if (enumIndex == EnumIndex.OFFERADD || enumIndex == EnumIndex.OFFERLIST){			//постановка заявки и прайс лист
                r = Config.LOGIN+ ';' + Config.PASSWORD+ ';' + Config.CULTURE+ ';' + Config.WMID + ';' + zCoin;
            }
            if (enumIndex == EnumIndex.OFFERMY || enumIndex == EnumIndex.BALANCE){			//мои заявки и баланс портфеля
                r = Config.LOGIN+ ';' + Config.PASSWORD+ ';' + Config.CULTURE+ ';' + Config.WMID;
            }
            if (enumIndex == EnumIndex.TOOLS){			//цены на коины
                r = Config.LOGIN+ ';' + Config.PASSWORD+ ';' + Config.CULTURE;
            }
            if (enumIndex == EnumIndex.HISTORYTRANSACTION || enumIndex == EnumIndex.HISTORYTRADING){			//мои сделки
                r = Config.LOGIN+ ';' + Config.PASSWORD+ ';' + Config.CULTURE+ ';' + Config.WMID + ';' + zCoin + ';' + DateStart + ';' + DateEnd;
            }
            if (enumIndex == EnumIndex.TICK ){			//мои сделки
                r = Config.LOGIN+ ';' + Config.PASSWORD+ ';' + Config.CULTURE+ ';' + Config.WMID + ';' + tickID + ';' + kindTick;
            }
            Log.d(TAG, r);

            try{

                byte[] zl = digest.digest(r.getBytes("UTF-8"));

                base64 = android.util.Base64.encodeToString(zl, android.util.Base64.NO_WRAP);
            }catch (UnsupportedEncodingException e){e.printStackTrace();}
        }catch (NoSuchAlgorithmException e){e.printStackTrace();}
        return base64;
    }
}
