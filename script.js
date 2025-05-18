document.getElementById("patientForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const name = document.getElementById("name").value;
    const gender = document.getElementById("gender").value;
    const dob = document.getElementById("dob").value;
    const address = document.getElementById("address").value;
    const contact = document.getElementById("contact").value;
    const bloodGroup = document.getElementById("bloodGroup").value;
    const history = document.getElementById("history").value;

    if (contact.length !== 10 || isNaN(contact)) {
        alert("Contact number must be 10 digits!");
        return;
    }

    const dobParts = dob.split("-");
    const patientID = dobParts[2].slice(-2) + dobParts[1] + dobParts[0];

    const patient = {
        id: patientID,
        name,
        gender,
        dob,
        address,
        contact,
        bloodGroup,
        history,
    };

    localStorage.setItem(patientID, JSON.stringify(patient));

    document.getElementById("result").innerHTML = `
        <strong>Patient Registered Successfully!</strong><br>
        Patient ID: ${patientID}<br>
        Name: ${name}<br>
        Contact: ${contact}
    `;

    document.getElementById("patientForm").reset();
});

document.getElementById("searchBtn").addEventListener("click", function () {
    const searchValue = document.getElementById("searchInput").value.toLowerCase();
    let found = false;
    const resultBox = document.getElementById("searchResult");
    resultBox.innerHTML = "";

    for (let key in localStorage) {
        if (localStorage.hasOwnProperty(key)) {
            const patient = JSON.parse(localStorage.getItem(key));
            if (patient && (patient.id === searchValue || patient.name.toLowerCase().includes(searchValue))) {
                resultBox.innerHTML += `
                    <div>
                        <strong>ID:</strong> ${patient.id}<br>
                        <strong>Name:</strong> ${patient.name}<br>
                        <strong>Gender:</strong> ${patient.gender}<br>
                        <strong>DOB:</strong> ${patient.dob}<br>
                        <strong>Address:</strong> ${patient.address}<br>
                        <strong>Contact:</strong> ${patient.contact}<br>
                        <strong>Blood Group:</strong> ${patient.bloodGroup}<br>
                        <strong>History:</strong> ${patient.history}<br>
                        <button onclick='editPatient("${patient.id}")'>Edit</button>
                        <hr>
                    </div>
                `;
                found = true;
            }
        }
    }

    if (!found) {
        resultBox.innerHTML = "No patient found.";
    }
});

function editPatient(patientID) {
    const patient = JSON.parse(localStorage.getItem(patientID));
    if (patient) {
        document.getElementById("name").value = patient.name;
        document.getElementById("gender").value = patient.gender;
        document.getElementById("dob").value = patient.dob;
        document.getElementById("address").value = patient.address;
        document.getElementById("contact").value = patient.contact;
        document.getElementById("bloodGroup").value = patient.bloodGroup;
        document.getElementById("history").value = patient.history;

        alert("Patient details loaded. You can now update and resubmit the form.");
    }
}
