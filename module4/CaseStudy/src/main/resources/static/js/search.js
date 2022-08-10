function searchEmployee() {
    let employeeName = $("#searchEmployee").val();
    $.ajax({
        url: "http://localhost:8080/employee/searchName",
        data: {
            nameEmp: employeeName
        },
        type: "get",
        dataType: "json",
        success: function (response) {
            let result = '';
            for (let i = 0; i < response.length; i++) {
                result += `

    <tr>
        <td> ${response[i].employee_id}</td>
        <td> ${response[i].employee_name}</td>
        <td> ${response[i].employee_birthday}</td>
        <td> ${response[i].employee_salary}</td>
        <td> ${response[i].employee_id_card}</td>
        <td> ${response[i].employee_phone}</td>
        <td> ${response[i].employee_email}</td>
        <td> ${response[i].employee_address}</td>
        <td> ${response[i].user.getUserName()}</td>
        <td> ${response[i].division.getDivision_name()}</td>
        <td> ${response[i].education.getEducation_degree_name()}</td>
        <td> ${response[i].position.getPosition_name()}</td>
    </tr>
                `;

                // result += "<tr>"
                //     + "<td>"+ response[i].subjectId + "</td>"
            }
            $("#result").html(result);
            // $("#result").append(result);
        },
        error: function (e) {

        }
    });
}
