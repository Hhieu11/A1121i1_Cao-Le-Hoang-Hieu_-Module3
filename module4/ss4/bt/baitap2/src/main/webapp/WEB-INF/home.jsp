<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/28/2022
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        th, td, tr {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h1> To Khai Y Te</h1>
<div style="width: 100% ; border: 1px">
<form:form action="save" method="post" modelAttribute="customer">
    <span>Ho va Ten :</span>
    <form:input path="name"/>
    <br>
    <br>

    <span>Ngay thang nam sinh</span>
    <form:input path="date"/>

    <span> Gioi Tinh</span>
    <form:select path="gender">
        <form:option value="Nam">Nam</form:option>
        <form:option value="Nu">Nu</form:option>
        <form:option value="Khac">Khac</form:option>
    </form:select>

    <span> Quoc Gia</span>
    <form:select path="country">
        <form:option value="Viet Nam">Viet Nam</form:option>
        <form:option value="USA">USA</form:option>
        <form:option value="China">China</form:option>
        <form:option value="Laos">Laos</form:option>
        <form:option value="Khac">Khac</form:option>
    </form:select>

    <span>So Cmnd/Cccd :</span>
    <form:input path="cccd"/>
    <br>
    <br>


    <span> Thong tin di lai</span>
    <form:radiobutton path="go" value="Tau bay"/> Tau Bay
    <form:radiobutton path="go" value="Tau thuyen" /> Tau thuyen
    <form:radiobutton path="go" value="Oto"/>Oto
    <form:radiobutton path="go" value="Khac"/>Khac
    <br>
    <br>


    <span> So hieu phuong tien</span>
    <form:input path="seriVehicle"/>

    <span> So ghe </span>
    <form:input path="numChair"/>
    <br>
    <br>

    <span> Ngay khoi hanh</span>
    <form:input path="dateStart"/>

    <span> Ngay ket thuc</span>
    <form:input path="dateEnd"/>

    <br>
    <br>

    <span> Trong vong 14 ngay co di qua thanh pho nao ?</span>
    <form:input path="note"/>
    <br>
    <br>

    <span> Tinh thanh pho</span>
    <form:input path="city"/>

    <span> Quan/Huyen</span>
    <form:input path="district"/>


    <span> Xa/Phuong/Thi tran</span>
    <form:input path="commune"/>

    <br>
    <br>

    <span> Dia chi tam tru</span>
    <form:input path="address"/>

    <br>
    <br>

    <span> So dien thoai</span>
    <form:input path="phone"/>



    <span>Email</span>
    <form:input path="email"/>
    <br>

    <span>Trong vong 14 ngay qua Anh/Chi co xuat hien dau hieu nao sau day khong? </span>
    <br>
    <table style="border: 1px solid black;border-collapse: collapse">
        <tr>
            <th>Trieu chung</th>
            <th>Co</th>
            <th>Khong</th>
            <th>Trieu chung</th>
            <th>Co</th>
            <th>Khong</th>
        </tr>
        <tr>
            <td>Sot</td>
            <td>
                <form:radiobutton path="symptom" value="Sot"/>Yes
            </td>
            <td>
                <form:radiobutton path="symptom" value=""/>No
            </td>
            <td>Non</td>
            <td>
                <form:radiobutton path="symptom2" value="Non/Nuon non"/>Yes
            </td>
            <td>
                <form:radiobutton path="symptom2" value=""/>No
            </td>


        </tr>
        <tr>
            <td>Ho</td>
            <td>
                <form:radiobutton path="symptom3" value="Ho"/>Yes
            </td>
            <td>
                <form:radiobutton path="symptom3" value=""/>No
            </td>
            <td>Tieu Chay</td>
            <td>
                <form:radiobutton path="symptom4" value="Tieu chay"/>Yes
            </td>
            <td>
                <form:radiobutton path="symptom4" value=""/>No
            </td>


        </tr>
        <tr>
            <td>Kho tho</td>
            <td>
                <form:radiobutton path="symptom5" value="Kho tho"/>Yes
            </td>
            <td>
                <form:radiobutton path="symptom5" value=""/>No
            </td>
            <td>So huyet ngoai da</td>

            <td>
                <form:radiobutton path="symptom6" value="So huyet ngoai da"/>Yes
            </td>
            <td>
                <form:radiobutton path="symptom6" value=""/>No
            </td>


        </tr>
        <tr>
            <td>Dau hong</td>
            <td>
                <form:radiobutton path="symptom7" value="Dau hong"/>Yes
            </td>
            <td>
                <form:radiobutton path="symptom7" value=""/>No
            </td>
            <td>Phat ban ngoai da</td>
            <td>
                <form:radiobutton path="symptom8" value="Phat ban ngoai da"/>Yes
            </td>
            <td>
                <form:radiobutton path="symptom8" value=""/>No
            </td>


        </tr>

    </table>

    <span>Lich su phoi nhiem: Trong vong 14 ngay qua, Anh/Chi co:</span>
    <br>
    <table>
        <tr>
            <th></th>
            <th>Co</th>
            <th>Khong</th>
        </tr>
        <tr>
            <td>
                <span>Den trang trai chan nuoi/ cho dong vat tuoi song/ co so giet mo dong vat/ tiep xuc dong vat</span>
            </td>
            <td>
                <form:radiobutton path="infection" value="Den trang trai chan nuoi/ cho dong vat tuoi song/ co so giet mo dong vat/ tiep xuc dong vat"/> Yes
            </td>
            <td>
                <form:radiobutton path="infection" value=""/> No
            </td>
        </tr>
        <tr>
            <td>
                <span>Tiep xuc gan(<2m) voi nguoi mac benh viem duong ho hap do nCoV</span>
            </td>
            <td>
                <form:radiobutton path="infection1" value="Tiep xuc gan(<2m) voi nguoi mac benh viem duong ho hap do nCoV"/> Yes
            </td>
            <td>
                <form:radiobutton path="infection1" value=""/>No
            </td>
        </tr>
    </table>
    <form:button id="button" type="submit">Save</form:button>






</form:form>
</div>
</body>
</html>
