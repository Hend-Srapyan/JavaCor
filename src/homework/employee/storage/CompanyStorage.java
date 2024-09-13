package homework.employee.storage;

import homework.employee.model.Company;


public class CompanyStorage {

    private Company[] companies = new Company[10];
    private int size;

    public void add(Company company) {
        if (companies.length == size) {
            extendStorage();
        }
        companies[size++] = company;
    }

    private void extendStorage() {
        Company[] tmp = new Company[size + 10];
        System.arraycopy(companies, 0, tmp, 0, size);
        companies = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(companies[i]);
        }
    }


    public Company getCompanyByID(String id) {
        for (int i = 0; i < size; i++) {
            if (companies[i].getId().equals(id)) {
                return companies[i];
            }
        }
        return null;
    }

    public void searchCompanyByCompanyId(String id) {
        for (int i = 0; i < size; i++) {
            if (companies[i].getId().equals(id)) {
                System.out.println(companies[i]);
            }
        }
    }

}
