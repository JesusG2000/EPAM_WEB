package com.epam.examples.math_command;


import com.epam.examples.bean.Glob;
import com.epam.examples.util.parser.DataParser;
import com.epam.examples.util.parser.ParserException;
import com.epam.examples.util.parser.impl.FileDataParser;
import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.ProviderException;
import com.epam.examples.util.provider.impl.FileDataProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AllowableGlobTest {

    private AllowableGlob allowableGlob;
    private List<Glob> lines;
    private DataProvider dataProvider;
    private DataParser parser;


    @Before
    public void initAllowableGlob() throws ProviderException, ParserException {
        allowableGlob = new AllowableGlob();
        dataProvider = new FileDataProvider("src\\test\\resources\\information");
        parser = new FileDataParser(dataProvider);
        lines = parser.getGlobes();

    }

    @After
    public void clearAllowableGlob() {
        allowableGlob = null;
        parser = null;
        dataProvider = null;
        lines = null;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkOnException() {
        String expected = "true";
        String actual = allowableGlob.execute(lines.get(3));
        Assert.assertEquals(expected, actual);
    }

    @Test()
    public void checkOnResult() {
        String expected = "true";
        String actual = allowableGlob.execute(lines.get(1));
        Assert.assertEquals(expected, actual);
    }
}