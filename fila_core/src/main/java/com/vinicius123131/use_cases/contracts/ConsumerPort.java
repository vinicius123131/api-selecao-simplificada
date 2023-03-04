package com.vinicius123131.use_cases.contracts;

public interface ConsumerPort <I>{
    void execute(I input);
}
