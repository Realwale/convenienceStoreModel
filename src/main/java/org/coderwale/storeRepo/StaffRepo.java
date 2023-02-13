package org.coderwale.storeRepo;

import lombok.Getter;
import org.coderwale.model.Person;
import org.coderwale.model.Staff;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StaffRepo {
    private final List<Staff> list;

    public StaffRepo() {
        this.list = new ArrayList<>();
    }

    public Staff save(Person person){
        String id = "Staff_" + list.size()+1;
        Staff staff = new Staff(person.getName(), person.getAddress(), person.getAge(), id);
        list.add(staff);
        return staff;
    }

    public Staff delete(String id){
        Staff staff = findByID(id);
        if (staff != null ){
            list.remove(staff);
            return staff;
        }
        return null;
    }

    public Staff findByID( String id){
        for (Staff staff: list){
            if (staff.getId() == id){
                return staff;
            }
        }
        return null;
    }

}

