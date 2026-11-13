package com.prac26102026.prac1.practice.PagenationAndSorting.Controller;


import com.prac26102026.prac1.practice.PagenationAndSorting.Entity.EmployeePaginationEntity;
import com.prac26102026.prac1.practice.PagenationAndSorting.Service.EmployeePaginationService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/Pagination")
public class EmployeePaginationController {

    @Autowired
    private EmployeePaginationService employeePaginationService;

    @GetMapping("/allEmployees")
    public List<EmployeePaginationEntity> getAllEmployees() {
//        employeePaginationService.getAllEmployees();
//        return "All Employees";
        return employeePaginationService.getAllEmployees();
    }

    //    http://localhost:8080/pavan/api/Pagination/PageEmployees?pageNo=5&pageSize=5
//    http://localhost:8080/pavan/api/Pagination/PageEmployees?pageSize=5&pageNo=5
//    IF user not passing any value ffrom UI then default value will be taken from @RequestParam(required = false, defaultValue = "1") int pageNo
    @GetMapping("/PageEmployees")
    public List<EmployeePaginationEntity> getEmployeesByPage(
            @RequestParam(required = false, defaultValue = "1") int pageNo
            , @RequestParam(required = false, defaultValue = "5") int pageSize) {

        return employeePaginationService.getEmployeesByPage(PageRequest.of(pageNo, pageSize));
    }

    //    http://localhost:8080/pavan/api/Pagination/PageEmployees?pageNo=10&pageSize=5&sortBy=id&sortDirection=DESC
    @GetMapping("/SortEmployees")
    public List<EmployeePaginationEntity> getEmployeesByPageSort(
            @RequestParam(required = false, defaultValue = "1") int pageNo,
            @RequestParam(required = false, defaultValue = "5") int pageSize,
            @RequestParam(required = false, defaultValue = "ID") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDirection) {
////        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
////        Sort.by(sortBy).descending();
//
//        Sort sort=null;
//        if(sortBy.equalsIgnoreCase("asc"))
//        {
////            return employeePaginationService.getEmployeesByPage(PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending()));
//       Sort.by(sortBy).ascending();
//        }
//        else if(sortBy.equalsIgnoreCase("desc"))
//        {
//            Sort.by(sortBy).descending();
//        }
////        else
////        {
////            return employeePaginationService.getEmployeesByPage(PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending()));
////        }
//        return employeePaginationService.getEmployeesByPage(PageRequest.of(pageNo, pageSize, sort));
        Sort sort = null;
        if (sortDirection.equalsIgnoreCase("ASC")) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }
        return employeePaginationService.getEmployeesByPage(PageRequest.of(pageNo - 1, pageSize, sort));
    }


//    http://localhost:8080/pavan/api/Pagination/SearchSortEmployees?pageNo=1&pageSize=5&sortBy=firstname&sortDirection=ASC&search=Rahul
//    If there is no name in the page like not in 1 to 5 we wont get any result, if its there we ll get
    @GetMapping("/SearchSortEmployees")
    public List<EmployeePaginationEntity> getEmployeesByPageSortSearch(
            @RequestParam(required = false, defaultValue = "1") int pageNo,
            @RequestParam(required = false, defaultValue = "5") int pageSize,
            @RequestParam(required = false, defaultValue = "ID") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDirection,
            @RequestParam(required = false, defaultValue = "A") String search
            ) {
    Sort sort = null;
        if (sortDirection.equalsIgnoreCase("ASC")) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }
        return employeePaginationService.getEmployeesByPageSortSearch(PageRequest.of(pageNo - 1, pageSize, sort), search);
    }

}


