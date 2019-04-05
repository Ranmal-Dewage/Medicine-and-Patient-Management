# Medicine and Patient Management System

## Introduction:

The system demonstrated in this report is a medicine and patient information management system where a consumer is prompt to select medicine management or patient management. In Medicine Management you can enter new medicine detail, add or deduct medicine quantity, search particular medicine detail, delete medicine details from the system which is stored in a HashMap inside the Database Bundle but if you want, we can further improve this system by storing data in HapMap to a Document or Relational database but for simplicity we have use a HashMap to store data. You can perform enter new patient detail, search particular patient detail, delete patient details from the Patient Management. We have two versions in Medicine Publisher, one is improved version and other one is the old version. In the new version you are prompt to enter a new detail called medicine description which is not in the older version. The diagram shown below demonstrates how the consumer and service publishers interact with each other.

<img src="https://i.ibb.co/NSNPCzS/Untitled.png" alt="Untitled" border="0">
Figure_1: Overview of the Medicine and Patient Management System
<p></p><br />

<img src="https://i.ibb.co/nwNJyXw/Untitled.png" alt="Untitled" border="0">
Figure_2: Component Diagram of the Medicine and Patient Management System
<p></p><br />

## Deployment Guide

<img src="https://i.ibb.co/zQJNjGp/Untitled.png" alt="Untitled" border="0">
Figure_1: Run Configuration for Medicine Publisher Version 1.0.1
<p></p><br />

** When you run the configuration above sometimes bundles may start out of order and some bundle exception may occur, if something like that happens stop all 4 bundles and start them again in given order below.  ** 

<img src="https://i.ibb.co/kqBj10z/Untitled.png" alt="Untitled" border="0">
Figure_2: Before starting bundles
<p></p><br />

<img src="https://i.ibb.co/j5hNyLb/Untitled.png" alt="Untitled" border="0">
Figure_3: Bundle starting process
<p></p><br />

<img src="https://i.ibb.co/WPHLsvR/Untitled.png" alt="Untitled" border="0">
Figure_4: After starting bundles
<p></p><br />

## Sample screenshots

#### Usage of medicine Service

<img src="https://i.ibb.co/Hdyg8Ry/Capture.png" alt="Capture" border="0">
Fig1: Demonstrates how a user can navigate to use the medicine service
<p></p><br />

<img src="https://i.ibb.co/c8TQsGP/Capture.png" alt="Capture">
Fig 2: Process of adding medicine to the system  
<p></p><br />
 
<img src="https://i.ibb.co/C5y396q/Capture.png" alt="Capture" border="0"">
Fig3:Process of displaying medicine with specific medicine id  
<p></p><br />
 
<img src="https://i.ibb.co/ZTCTyD0/Capture.png" alt="Capture" border="0">
Fig4: Process of increasing quantity of a specific medicine  
<p></p><br />
 
<img src="https://i.ibb.co/kDGdP5w/Capture.png" alt="Capture" border="0">
Fig5: Process of deducting a quantity of a specific medicine  
<p></p><br />

<img src="https://i.ibb.co/2y3Vrnz/Capture.png" alt="Capture" border="0">
Fig6: Process of removing a medicine entry from the system entirely  
<p></p><br />

##### Usage of Paitient Service

<img src="https://i.ibb.co/FXcBV2R/Capture.png" alt="Capture" border="0">
Fig7: Demonstrate how to navigate to use the paitent service  
<p></p><br />

<img src="https://i.ibb.co/MgvLNhP/Capture.png" alt="Capture" border="0">
Fig8:Process of adding a paitent to the system  
<p></p><br />

<img src="https://i.ibb.co/xgnrFSm/Capture.png" alt="Capture" border="0">
Fig9:Process of displaying a specific paitent with patient id  
<p></p><br />

<img src="https://i.ibb.co/N6VGj6J/Capture.png" alt="Capture" border="0">
Fig10: Process of removing a paitent with specific paitent id  
<p></p><br />

#### After updating medicine service to new version

<img src="https://i.ibb.co/J589ypG/Capture.png" alt="Capture" border="0">
Fig11: Process of adding medicine using the new version  
<p></p><br />

<img src="https://i.ibb.co/tbX6QNn/Capture.png" alt="Capture" border="0">
Fig12: Process of displaying medicine using the new version  
<p></p><br />

