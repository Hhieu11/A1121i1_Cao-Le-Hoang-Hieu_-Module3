use quan_li_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất. --

select * ,max(credit) from subject;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.--
select `subject`.sub_id,sub_name,credit,`status` , max(mark)
from `subject`  left join mark
on `subject`.sub_id=mark.sub_id;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần --

select  student.student_id,student_name,address,phone,`status`,class_id, avg(mark)
from student join mark on student.student_id=mark.student_id
group by student.student_id 
order by avg(mark) desc;
