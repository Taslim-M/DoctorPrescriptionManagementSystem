# Doctor Prescription Management System

The aim of this project is to design a database system that models a unified national health system such that any doctor within the UAE – as an example – can access information regarding any patient’s medical history. A patient can make any number of visits to any number of doctors, where each visit has a unique visit ID and a date marking when that visit occurred. Any number of medications can be prescribed in every visit, and some visits may not have any medicine prescribed. A patient has an age, gender, full name, height, blood types, weight, and finally, a unique Emirates ID number. Doctors have a full name, a specialization, gender, and, also, an emirates ID number. Finally, even medicine has a name, manufacturer, age restriction, the number doses per day, and, finally, an unique ID. The number of doses per day can be from 1 to a maximum of 9. A medicine can be prescribed to a patient following the visit s/he has made with a doctor, if the age of the patient is not less than the age restriction of the medicine being assigned.

## ER Diagram

<img src="https://github.com/Taslim-M/DoctorPrescriptionManagementSystem/blob/master/src/jdbcgui/ER_Diagram.JPG" />

## Relational Model

<img src="https://github.com/Taslim-M/DoctorPrescriptionManagementSystem/blob/master/src/jdbcgui/logical_relations.JPG" />
