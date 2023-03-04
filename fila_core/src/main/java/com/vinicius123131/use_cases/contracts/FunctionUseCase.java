package com.vinicius123131.use_cases.contracts;

public interface FunctionUseCase <I, O>{
    O execute(I input);
}
