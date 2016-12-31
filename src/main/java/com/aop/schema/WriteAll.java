package com.aop.schema;

/**
 * Created by xugenli on 2016/12/29.
 */
public interface WriteAll {
    void write();

    void writeSong(String lyc);

    void writeException(String exc) throws Exception;

    String writeReturn();

    void writeAround(String args);

}
