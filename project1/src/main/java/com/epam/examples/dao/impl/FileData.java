package com.epam.examples.dao.impl;

import com.epam.examples.bean.Glob;
import com.epam.examples.bean.dto.impl.SectionCalcParameters;
import com.epam.examples.dao.DaoException;
import com.epam.examples.util.parser.DataParser;
import com.epam.examples.util.parser.ParserException;
import com.epam.examples.util.parser.impl.FileDataParser;
import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.ProviderException;

import java.util.List;

class FileData {


    List<Glob> getGlobData(DataProvider fileDataProvider) throws DaoException {
        try {
            DataParser parser = new FileDataParser(fileDataProvider);
            return parser.getGlobes();
        } catch (ParserException | ProviderException e) {
            throw new DaoException("error with getting info ", e);
        }

    }


    List<SectionCalcParameters> getSectionCalcParametersData(DataProvider fileDataProvider) throws DaoException {
        try {
            DataParser parser = new FileDataParser(fileDataProvider);
            return parser.getSectionParams();
        } catch (ParserException | ProviderException e) {
            throw new DaoException("error with getting info ", e);
        }
    }
}
