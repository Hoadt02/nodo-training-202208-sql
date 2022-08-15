--BÀI TẬP CHƯƠNG 2
-- 1.Chọn toàn bộ thông tin trong bảng SALGRADE
SELECT *
FROM SALGRADE;

-- 2.Chọn toàn bộ thông tin trong bảng EMP
SELECT *
FROM EMP;

-- 3.Hiển thị mọi loại nghề nghiệp
SELECT *
FROM EMP
WHERE JOB = 'ANALYST'
   OR JOB = 'CLERK'
   OR JOB = 'MANAGER'
   OR JOB = 'PRESIDENT'
   OR JOB = 'SALESMAN';

-- 4.Hiển thị tên nhân viên và thu nhập trong một năm (REMUNERATION)
SELECT DISTINCT ENAME, (SAL * 12) AS REMUNERATION
FROM EMP

-- 5.Hiển thị theo nội dung dưới đây
SELECT ENAME || 'HAS HELP THE POSITION OF ' || JOB || 'IN DEPT ' || DEPT_NO || 'SINCE ' ||
       TO_CHAR(HIREDATE, 'DD-MM-YYYY')
FROM EMP

-- 6.Hiển thị cấu trúc bảng emp;
DESC EMP;

-- 7.Thay đổi nhãn và định dạng hiển thị của cột sal và hiredate trong bảng emp
SELECT DISTINCT TO_CHAR(SAL, '9,999.00')        AS SALARY,
                TO_CHAR(HIREDATE, 'DD-MM-YYYY') AS DATE_NGAY
FROM EMP;
