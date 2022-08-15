--BÀI TẬP CHƯƠNG 12.
-- 1. Viết đoạn chương trình tìm kiếm các hàng trong bảng EMP với biến được đưa từ
-- ngoài vào là &1 dạng JOb_type(emp.job%type) và đưa ra thông báo thích hợp
-- vào bảng MESSAGES.
DECLARE
    CURSOR EMP_CUR IS
        SELECT ENAME, HIREDATE, SAL
        FROM EMP
        WHERE JOB = 'CLERK';

    C_EMP EMP_CUR%ROWTYPE;
    RESULTS NUMBER(2) := 0;
BEGIN
    OPEN EMP_CUR;
    LOOP
        FETCH EMP_CUR INTO C_EMP;
        EXIT WHEN EMP_CUR%NOTFOUND;
        RESULTS := RESULTS + 1;
    end loop;

    INSERT INTO MESSAGES_HOADT(NUMCOL1) VALUES (RESULTS);
    CLOSE EMP_CUR;
end;

TRUNCATE TABLE MESSAGES_HOADT;
-- 2. Viết đoạn chương trình ghi dữ liệu vào bảng MESSAGES với cột NUMCOL1 mang giá trị
-- là 1 nếu là row 1 được Insert, 2 nếu row 2 được Insert... . Không được Insert những
--     row có giá trị là 6 hoặc 8, thoát khỏi vòng lặp insert sau giá trị 10. Commit sau vòng
--                                                         lặp.
SELECT * FROM MESSAGES_HOADT;

DECLARE
    SO_DONG NUMBER(2) := 1;
BEGIN
    LOOP
        IF (SO_DONG = 6 OR SO_DONG = 8) THEN
            INSERT INTO MESSAGES_HOADT(NUMCOL1)
            VALUES (NULL);
        ELSE
            INSERT INTO MESSAGES_HOADT(NUMCOL1)
            VALUES (SO_DONG);
        end if;
        SO_DONG := SO_DONG + 1;
        EXIT WHEN SO_DONG = 11;
    end loop;
end;

-- 3. Liệt kê các cột ENAME, HIREDATE, SAL Với điều kiện EMPNO bằng giá trị biến
-- &EMPLOYEE_NO được đưa vào, sau đó kiểm tra:
-- 1.1 Có phải mức lương lớn hơn 1200
-- 1.2 Tên nhân viên có phải có chứa chữ T
-- 1.3 ngày gia nhập cơ quan có phải là tháng 10 (DEC)
-- và đưa giá trị kiểm tra này vào bảng message cột charcol1 (thử với các giá trị 7654, 7369,
-- 7900, 7876)
DECLARE
    CURSOR EMP_CUR
        IS
    SELECT ENAME, HIREDATE, SAL
    FROM EMP
    WHERE EMPNO = 7369;

    C_EMP EMP_CUR%ROWTYPE;
    MES VARCHAR2(60) := '';
BEGIN
    OPEN EMP_CUR;
    FETCH EMP_CUR INTO C_EMP;

    IF (C_EMP.ENAME LIKE '%T%') THEN
        MES := MES || C_EMP.ENAME;
    end if;

    IF (C_EMP.SAL > 1200) THEN
        MES := MES || 'CÓ LƯƠNG' || C_EMP.SAL;
    end if;

    IF (TO_CHAR(C_EMP.HIREDATE, 'MM') = 10) THEN
        MES := MES || 'GIA NHẬP CÔNG TY VÀO THÁNG 10';
    end if;

    INSERT INTO MESSAGES_HOADT(CHARCOL1)
    VALUES (MES);

    CLOSE EMP_CUR;
end;

SELECT * FROM MESSAGES_HOADT;

-- 4. Đưa vào vòng lặp v từ 1 đến 10 lệnh:
-- UPDATE messages
-- SET numcol2=100
-- WHERE numcol1 = v;
-- nếu bất kỳ một lần update nào đó có số lượng row >1 thì exit khỏi vòng lặp.
DECLARE
    V NUMBER := 0;
    CURSOR C_MESS IS
    SELECT NUMCOL1, COUNT(NUMCOL1) AS COUNT
    FROM MESSAGES_HOADT
    WHERE NUMCOL1 IS NOT NULL
    GROUP BY NUMCOL1
    ORDER BY NUMCOL1 ASC;

    V_MESS C_MESS%ROWTYPE;
BEGIN
    OPEN C_MESS;
    WHILE V < 11
        LOOP
            FETCH C_MESS INTO V_MESS;
            IF V_MESS.COUNT > 1 THEN
                RETURN;
            ELSE
                UPDATE MESSAGES_HOADT SET NUMCOL2 = 100 WHERE NUMCOL1 = V;
            end if;

            V := V + 1;
        end loop;
end;
