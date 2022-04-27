use quan_li_sinh_vien;
-- Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi --
select address , count(student_id) as so_luong_sv
from student
group by address;

-- Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG --

select  student.student_id,student_name, avg(mark)
from student join mark on student.student_id=mark.student_id
group by student.student_id;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 10 --
select  student.student_id,student_name, avg(mark)
from student join mark on student.student_id=mark.student_id
group by student.student_id
having avg(mark)>=10;

-- Sử dụng Having và All để tìm học viên có điểm trung bình lớn nhất --
select  student.student_id,student_name, avg(mark)
from student join mark on student.student_id=mark.student_id
group by student.student_id
having avg(mark) >= all(select avg(mark) from mark group by mark.student_id);

