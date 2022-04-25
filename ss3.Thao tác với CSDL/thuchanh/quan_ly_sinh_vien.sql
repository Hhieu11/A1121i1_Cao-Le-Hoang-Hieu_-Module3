use quan_li_sinh_vien;
INSERT INTO class
VALUES (1, 'A1', '2008-12-20', 1),
(2, 'A2', '2008-12-22', 1),
 (3, 'B3', current_date, 0);

INSERT INTO student (student_name, address, phone, `status`, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1),
 ('Hoa', 'Hai phong','', 1, 1),
('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO mark (sub_id, student_id, mark, exam)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       
 -- truy vấn dữ liệu --
 
 SELECT *
FROM Student;
-- --

SELECT *
FROM Student
WHERE Status = true;  

--
SELECT *
FROM subject
WHERE Credit < 10;
--
select s.student_id,student_name,c.class_name
from student s join class c on s.class_id=c.class_id;
--
select s.student_id,student_name,c.class_name
from student s join class c on s.class_id=c.class_id
where class_name="A1";

--
SELECT S.Student_id, S.Student_Name, Sub.Sub_Name, M.Mark
FROM Student S join Mark M on S.Student_Id = M.Student_Id join Subject Sub on M.Sub_Id = Sub.Sub_Id;
--
SELECT S.Student_Id, S.Student_Name, Sub.Sub_Name, M.Mark
FROM Student S join Mark M on S.Student_Id = M.Student_Id join Subject Sub on M.Sub_Id = Sub.Sub_Id
WHERE Sub.Sub_Name = 'CF';

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’ --

select * from student
where student_name like "h%";

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12 --

select * from class
where month(start_date)=12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5. --
select * from subject
where credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2. --

SET SQL_SAFE_UPDATES = 0;
update student
set class_id = 2
where student_name="Hung";

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần. --

select student.student_name, `subject`.sub_name,mark.mark
from mark
inner join student  on  student.student_id = mark.student_id
inner join `subject` on  `subject`.sub_id = mark.sub_id
order by mark.mark desc;
