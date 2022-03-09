package resident;

import java.util.List;

public class ResidentApi {

    private List<Resident> residentList;

    public ResidentApi(List<Resident> residentList) {
        this.residentList = residentList;
    }


    public void updateResidents(double time) {
        for (Resident resident : residentList) {
            resident.curTime = time;
            resident.doAction();
        }
    }
}
