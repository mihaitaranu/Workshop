/**
 * Created by Taranu on 11/05/15.
 */
var employeesList = [
    {
        firstName: 'John',
        lastName: 'King',
        phone: '0123456789',
        salary: 4500
    },
    {
        firstName: 'Steven',
        lastName: 'Gerard',
        phone: '0123456789',
        salary: 4500
    },
    {
        firstName: 'Diana',
        lastName: 'Ross',
        phone: '0123456789',
        salary: 4500
    },
    {
        firstName: 'Mike',
        lastName: 'Bob',
        phone: '0123456789',
        salary: 4500
    },
    {
        firstName: 'Emily',
        lastName: 'Hudson',
        phone: '0123456789',
        salary: 4500
    }
];
var currentList = employeesList;

function showList(list) {
    currentList = list;
    list=sortByField(list);
    var myTable = '<table class="table" border="1"><tr><th>First Name</th><th>Last Name</th><th>Phone</th><th>Salary</th><th>Stergere</th><th>Vizualizare</th></tr>';

    for (var i in list) {
        var alertList = list[i].firstName + " " + list[i].lastName;
        myTable += '<tr><td>' + list[i].firstName + '</td><td>' +
            list[i].lastName + '</td><td>' + list[i].phone + '</td><td>' + list[i].salary +
            '</td><td><button onclick="deleteElement(' + i + ')">Sterge elementul</button></td>' +
            '<td><button onclick="alert(\'' + alertList + '\')">Vizualizare</button></td>' +
            '</tr>';

    }
    myTable += '<tr id="statistics"></tr></table>';
    var container = document.getElementById('listcontainer');
    container.innerHTML = myTable;
    setStatistics();
}
var Employee = function (firstName, lastName, phone, salary) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.salary = parseFloat(salary);
}
function addEmployee() {
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var phone = document.getElementById("phone").value;
    var salary = document.getElementById("salary").value;
    employeesList.push(new Employee(firstName, lastName, phone,
        salary));
}
function showSalaryTotal() {
    var totalSalary = 0;
    for (var i in currentList) {
        totalSalary += currentList[i].salary;
    }
    var container = document.getElementById("salaryTotal");
    container.innerHTML = "<p>Total salary: " + totalSalary + "</p>";
}
function deleteLastEmployee() {
    employeesList.pop();
    showList(currentList);
}
function deleteElement(i) {
    employeesList.splice(i, 1);
    showList(currentList);
}
function setStatistics() {
    var statisticsString = "";
    var firstNamelist = [];
    var lastNameList = [];
    var phoneList = [];
    var salarysTotal = 0;
    var statisticsContainer = document.getElementById("statistics")

    for (var i in currentList) {
        firstNamelist.push(currentList[i].firstName);
        lastNameList.push(currentList[i].lastName);
        phoneList.push(currentList[i].phone.substr(0, 5));
        salarysTotal += currentList[i].salary;

    }

    var averageSalary = salarysTotal / currentList.length;

    var firstNameMap = {};
    var maxNumber = 1;
    for (var i = 0; i < firstNamelist.length; i++) {
        if (firstNameMap[firstNamelist[i]] != null) {
            firstNameMap[firstNamelist[i]] += 1;
            if (firstNameMap[firstNamelist[i]] > maxNumber) {
                maxNumber = firstNameMap[firstNamelist[i]];
            }
        } else {
            firstNameMap[firstNamelist[i]] = 1;
        }
    }

    var lastNameMap = {};
    for (var i = 0; i < lastNameList.length; i++) {
        if (lastNameMap[lastNameList[i]] != null) {
            lastNameMap[lastNameList[i]] += 1;

        } else {
            lastNameMap[lastNameList[i]] = 1;
        }
    }

    var phoneMap = {};
    var maxPhoneNumber = 1;
    for (var i = 0; i < phoneList.length; i++) {
        if (phoneMap[phoneList[i]] != null) {
            phoneMap[phoneList[i]] += 1;
            if (phoneMap[phoneList[i]] > maxPhoneNumber) {
                maxPhoneNumber = phoneMap[phoneList[i]];
            }
        } else {
            phoneMap[phoneList[i]] = 1;
        }
    }

    function getKeyByValues(object, value) {
        for (var prop in object) {
            if (object.hasOwnProperty(prop)) {
                if (object[prop] === value)
                    return prop;
            }
        }
    }

    wantedPhoneString = getKeyByValues(phoneMap, maxPhoneNumber);
    wantedPhoneStringCS = wantedPhoneString.charAt(0);
    for (var i = 1; i < wantedPhoneString.length; i++) {
        wantedPhoneStringCS += ", " + wantedPhoneString.charAt(i);
    }

    statisticsString += '<td>' + getKeyByValues(firstNameMap, maxNumber) + '</td><td>' + Object.keys(lastNameMap).length + '</td>' +
        '<td>' + wantedPhoneStringCS + '</td><td>' + averageSalary + '</td>';
    statisticsContainer.innerHTML = statisticsString;

}

function sortByField(listname) {
    var e = document.getElementById("fieldToSort");
    var field = e.options[e.selectedIndex].value;
    wantedList = sortBy(listname,field);
    return wantedList;
}
function sortBy(list,fieldName) {
    return list.sort(function (a, b) {
        if (a[fieldName] < b[fieldName]) return -1;
        if (a[fieldName] > b[fieldName]) return 1;
        return 0;
    })
}

function search() {
    wantedList=[];
    var searchKey = document.getElementById("searchKey").value;
    for(var i in employeesList){
        var employee=employeesList[i];
        for( var prop in employee){
            if(employee.hasOwnProperty(prop)){
                if(employee[prop]=== searchKey){
                    wantedList.push(employee);
                }
            }
        }
    }
    showList(wantedList);
}