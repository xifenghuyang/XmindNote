package com.jike.hotdrink;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaWithHook extends HotDrinkTemple{

    @Override
    public void brew(){
        System.out.println("Brewing tea");
    }

    @Override
    public void addCondiments(){
        System.out.println("Adding lemon");
    }

    /**
     * 子类通过Hook方法，影响父类中算法步骤，
     * 给模板方法提供一定灵活性
     * @return
     */
    @Override
    public boolean wantCondimentsHook(){
        System.out.println("Condiments, yes or no? please input(y/n):");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String result = "";
        try{
            result = in.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        if(result.equals("n")){
            return false;
        }else {
            return true;
        }
    }

}
