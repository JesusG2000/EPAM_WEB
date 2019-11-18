package com.epam.examples.math_operation;

import com.epam.examples.entity.Dot;
import com.epam.examples.entity.Glob;

public interface Operation {
    double takeSurfaceArea(Glob glob) throws MathException;

    double takeCapacity(Glob glob) throws MathException;

    boolean isGlob(Glob glob) throws MathException;

    double takeVolumeRatio(Glob glob, String axis, Dot first) throws MathException;

    boolean isTouchSomeAxis(Glob glob) throws MathException;
}
