package edu.hw4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationError {

    private String errorMessage;

    protected ValidationError() {

    }

    private ValidationError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Set<ValidationError> check(Animal animal) {
        Set<ValidationError> setOfValidationErrorForAnimal = new HashSet<>();
        if (animal.name() == null) {
            setOfValidationErrorForAnimal.add(new ValidationError("Name is null"));
        } else if (animal.name().isEmpty()) {
            setOfValidationErrorForAnimal.add(new ValidationError("Name is empty"));
        }
        if (animal.type() == null) {
            setOfValidationErrorForAnimal.add(new ValidationError("Type is null"));
        }
        if (animal.sex() == null) {
            setOfValidationErrorForAnimal.add(new ValidationError("Sex is null"));
        }
        if (animal.age() < 0) {
            setOfValidationErrorForAnimal.add(new ValidationError("Age is a negative number"));
        }
        if (animal.height() == 0) {
            setOfValidationErrorForAnimal.add(new ValidationError("Height is null"));
        }
        if (animal.weight() == 0) {
            setOfValidationErrorForAnimal.add(new ValidationError("Weight is null"));
        }
        if (animal.height() < 0) {
            setOfValidationErrorForAnimal.add(new ValidationError("Height is a negative number"));
        }
        if (animal.weight() < 0) {
            setOfValidationErrorForAnimal.add(new ValidationError("Weight is a negative number"));
        }
        return setOfValidationErrorForAnimal;
    }

    public String checkUpdate(Animal animal) {
        List<String> s = new ArrayList<>();
        if (animal.name() == null) {
            s.add("name : Name is null");
        }
        if (animal.name().isEmpty()) {
            s.add("name : Name is empty");
        }
        if (animal.type() == null) {
            s.add("type : Type is null");
        }
        if (animal.sex() == null) {
            s.add("sex : Sex is null");
        }
        if (animal.age() < 0) {
            s.add("age : Age is a negative number");
        }
        if (animal.height() <= 0) {
            s.add("height : Height is a negative number");
        }
        if (animal.weight() <= 0) {
            s.add("weight : Weight is a negative number");
        }
        return s.toString();
    }
}
