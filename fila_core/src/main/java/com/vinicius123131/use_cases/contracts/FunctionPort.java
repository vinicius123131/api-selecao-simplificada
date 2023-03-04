package com.vinicius123131.use_cases.contracts;

public interface FunctionPort <I, O>{
    O execute(I input);
}
