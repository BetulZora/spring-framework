-- These codes were great when we were doing drop if it exists
--INSERT INTO EMPLOYEE(id,name)
--VALUES(1,'Mike Smith');


--INSERT INTO student(id, first_name,last_name,email)
--VALUES(1,'Mike',' Smith','mike@cydeo.com');

--if the id is autogenerated, use this template
--Be sure that the @Id field in POJO has @GeneratedValue(strategy = GenerationType.IDENTITY)
--field names used here must match what is renamed by @Table and @Column
--nothing needs to be inserted into @Transient fields
INSERT INTO students( student_first_name,last_name,email)
VALUES('Mike',' Smith','mike@cydeo.com');

INSERT INTO EMPLOYEE(name)
VALUES('Mike Smith');
INSERT INTO EMPLOYEE(name)
VALUES('Jane Austin');