package org.daniel.quickstart;

import io.quarkus.test.Mock;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Mock
public class MockExpensiveService implements ExpensiveService{
    @Override
    public int calculate() {
        return 20;
    }
}
