package org.daniel.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RealExpensiveService implements ExpensiveService {

    @Override
    public int calculate() {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100;
    }
}
