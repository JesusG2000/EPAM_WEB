package com.epam.examples.math_command;

import com.epam.examples.bean.Dot;
import com.epam.examples.bean.Glob;
import com.epam.examples.controller.Command;
import com.epam.examples.service.CalcService;
import com.epam.examples.service.ServiceException;
import com.epam.examples.service.ServiceFactory;

public class CalcVolumeRatio implements Command {
    @Override
    public String execute(String data) {
        String []info= data.split(" ");
        double x=Double.parseDouble(info[0]);
        double y=Double.parseDouble(info[1]);
        double z=Double.parseDouble(info[2]);
        double radius=Double.parseDouble(info[3]);
        String axis=info[4];
        double x1=Double.parseDouble(info[5]);
        double y1=Double.parseDouble(info[6]);
        double z1=Double.parseDouble(info[7]);
        try{
            CalcService calcService = ServiceFactory.getCalcService();
            return calcService.takeVolumeRatio(new Glob(new Dot(x,y,z),radius),axis,new Dot(x1,y1,z1))+"";
        }catch (ServiceException e) {
            return e.getMessage();
        }
    }
}
