package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Core {

    private List<Integer> numeros = new ArrayList<>();

    public Core(List<Integer> numeros) {
        this.numeros = numeros;
        Collections.sort(this.numeros);
    }

    public void addNumber(Integer n) {
        this.numeros.add(n);
        Collections.sort(this.numeros);
    }

    public void resetList() {
        this.numeros.clear();
    }

    public boolean isEmpty() { return this.numeros.isEmpty(); }

    public Integer maior() {
        return this.numeros.get(this.numeros.size() - 1);
    }

    public Integer menor() {
        return this.numeros.get(0);
    }

    public Double media() {
        Double soma = new Double(0);
        for (Integer n : numeros) {
            soma += n;
        }
        return soma / numeros.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer n : numeros) {
            sb.append(n);
            sb.append(" ");
        }
        return sb.toString();
    }
}
