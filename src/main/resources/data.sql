INSERT INTO doc_type (version, name, code) VALUES
(0, 'Свидетельство о рождении', '03'),
(0, 'Военный билет', '07'),
(0, 'Временное удостоверение, выданное взамен военного билета', '08'),
(0, 'Паспорт иностранного гражданина', '10'),
(0, 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу', '11'),
(0, 'Вид на жительство в Российской Федерации', '12'),
(0, 'Удостоверение беженца', '13'),
(0, 'Разрешение на временное проживание в Российской Федерации', '15'),
(0, 'Свидетельство о предоставлении временного убежища на территории Российской Федерации', '18'),
(0, 'Паспорт гражданина Российской Федерации', '21'),
(0, 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства', '23'),
(0, 'Удостоверение личности военнослужащего Российской Федерации', '24'),
(0, 'Иные документы', '91');

INSERT INTO country (version, name, code) VALUES
(0, 'Российская Федерация', '643'),
(0, 'Австрия', '040'),
(0, 'Германия', '276'),
(0, 'Испания', '724'),
(0, 'Италия', '380');

INSERT INTO Organization (version, name, full_name, inn, kpp, address, phone, is_active) VALUES
(0, 'MTS org', 'MTS ogranization', '1234567890', '987654321', 'Russia, Moscow', '+79851231212', FALSE),
(0, 'TestOrg', 'TestOrgFullName', '111', '555', 'Address', '+1111111', TRUE),
(0, 'TestOrg', 'TestOrgFull', '111', '666', 'Add', '+2222222', TRUE);

INSERT INTO Office (version, name, address, phone, is_active, organization_id) VALUES
(0, 'MTS office', 'Russia, Moscow, Random str.', '+75554443322', TRUE, 1),
(0, 'Test office', 'Test office address', '111', FALSE, 1);

INSERT INTO User (version, first_name, second_name, middle_name, position, phone, doc_type_id, document_number, document_date, country_id, is_identified, office_id) VALUES
(0, 'firstName1', 'secondName1', 'middleName1', 'manager', '11111', 1, '11 1111', '2018-01-01', 1, TRUE, 1),
(0, 'firstName2', 'secondName2', 'middleName2', 'security', '22222', 3, '22 2222', '2018-02-01', 2, FALSE, 2),
(0, 'firstName3', 'secondName3', 'middleName3', 'programmer', '33333', 5, '33 3333', '2018-03-01', 3, TRUE, 1),
(0, 'firstName4', 'secondName4', 'middleName4', 'boss', '44444', 7, '44 4444', '2018-04-01', 4, FALSE, 2),
(0, 'firstName5', 'secondName5', 'middleName5', 'economist', '55555', 9, '55 5555', '2018-05-01', 5, TRUE, 1);

INSERT INTO Account (version, login, password, name) VALUES
(0, 'admin@admin.com', 'adminpass', 'admin'),
(0, 'test@test.com', 'testpass', 'test');