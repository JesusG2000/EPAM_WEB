package com.epam.examples.math.operation.impl;

import com.epam.examples.bean.Dot;
import com.epam.examples.bean.Glob;
import com.epam.examples.controller.Controller;
import com.epam.examples.math.operation.MathException;
import com.epam.examples.math.operation.Operation;
import com.epam.examples.util.log.LogProvider;

import java.util.logging.Logger;

public class OperationImpl implements Operation {
    private static Logger log = LogProvider.getLOGGER(OperationImpl.class);
    @Override
    public double takeSurfaceArea(Glob glob) throws MathException {
        log.info("calc surface area");
        isGlob(glob);
        return glob.getRadius() * 4 * Math.pow(Math.PI, 2);

    }

    @Override
    public double takeCapacity(Glob glob) throws MathException {
        log.info("calc capacity");
        isGlob(glob);
        return Math.pow(glob.getRadius(), 3) * 4 / 3 * Math.PI;


    }

    @Override
    public boolean isGlob(Glob glob) throws MathException {
        log.info("check is glob");
        if (glob.getRadius() > 0) {
            return true;
        } else {
            throw new MathException("this glob doesn't exist");
        }
    }

    @Override
    public double takeVolumeRatio(Glob glob, String axis, Dot first) throws MathException {
        log.info("calc volume ratio");
        isGlob(glob);

        double segmentHeight;
        Dot radiusCoordinates = glob.getDot();

        switch (axis) {
            case "OX": {
                segmentHeight = Math.sqrt(Math.pow(radiusCoordinates.getZ() - first.getZ(), 2) + Math.pow(radiusCoordinates.getY() - first.getY(), 2));
                break;
            }
            case "OY": {
                segmentHeight = Math.sqrt(Math.pow(radiusCoordinates.getX() - first.getX(), 2) + Math.pow(radiusCoordinates.getZ() - first.getZ(), 2));
                break;
            }
            case "OZ": {
                segmentHeight = Math.sqrt(Math.pow(radiusCoordinates.getX() - first.getX(), 2) + Math.pow(radiusCoordinates.getY() - first.getY(), 2));
                break;
            }
            default: {
                throw new MathException("Unknown axis");
            }
        }
        return calcVolumeRatio(glob, glob.getRadius()-segmentHeight);

    }

    private double calcVolumeRatio(Glob glob, double segmentHeight) throws MathException {
        if (segmentHeight > 0) {
            double v1 = Math.PI * Math.pow(segmentHeight, 2) * (glob.getRadius() - segmentHeight / 3);
            double v2 = takeCapacity(glob) - v1;
            return v1 > v2 ? v1 / v2 : v2 / v1;

        } else {
            throw new MathException("this plane don't touch glob");
        }

    }

    @Override
    public boolean isTouchSomeAxis(Glob glob) throws MathException {
        log.info("check is glob touch some axis");
        isGlob(glob);
        return touchX(glob) || touchY(glob) || touchZ(glob);

    }

    private boolean touchZ(Glob glob) {
        Dot dot = glob.getDot();
        double radius = glob.getRadius();
        double distanceY = dot.getY();
        double distanceX = dot.getX();
        return radius == distanceY || radius == distanceX;
    }

    private boolean touchY(Glob glob) {
        Dot dot = glob.getDot();
        double radius = glob.getRadius();
        double distanceX = dot.getX();
        double distanceZ = dot.getZ();
        return radius == distanceX || radius == distanceZ;
    }

    private boolean touchX(Glob glob) {
        Dot dot = glob.getDot();
        double radius = glob.getRadius();
        double distanceZ = dot.getZ();
        double distanceY = dot.getY();
        return radius == distanceZ || radius == distanceY;
    }
}
