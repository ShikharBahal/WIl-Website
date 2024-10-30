document.addEventListener("DOMContentLoaded", () => {
    updateImages();
});

function updateImages() {
    const dropdown = document.getElementById("programDropdown");
    const imageGallery = document.getElementById("imageGallery");

    // Clear previous images
    imageGallery.innerHTML = "";

    // Define images and their corresponding pages for each category
    const images = {
        "6week": [
            { src: "Img/Cooking.png", page: "cooking.html", name: "Cooking" },
            { src: "Img/ChildMinding.png", page: "childMinding.html", name: "Child Minding" },
            { src: "Img/GM.png", page: "gardeningMaintenance.html", name: "Gardening Maintenance" }
        ],
        "6month": [
            { src: "Img/FirstAid.png", page: "firstAid.html", name: "First Aid" },
            { src: "Img/Landscaping.png", page: "landscaping.html", name: "Landscaping" },
            { src: "Img/LifeSkills.png", page: "lifeSkills.html", name: "Life Skills" },
            { src: "Img/Sewing.png", page: "sewing.html", name: "Sewing" }
        ],
        "all": [
            { src: "Img/Cooking.png", page: "cooking.html", name: "Cooking" },
            { src: "Img/ChildMinding.png", page: "childMinding.html", name: "Child Minding" },
            { src: "Img/GM.png", page: "gardeningMaintenance.html", name: "Gardening Maintenance" },
            { src: "Img/FirstAid.png", page: "firstAid.html", name: "First Aid" },
            { src: "Img/Landscaping.png", page: "landscaping.html", name: "Landscaping" },
            { src: "Img/LifeSkills.png", page: "lifeSkills.html", name: "Life Skills" },
            { src: "Img/Sewing.png", page: "sewing.html", name: "Sewing" }
        ]
    };

    // Get selected value and corresponding images
    const selectedProgram = dropdown.value;
    const selectedImages = images[selectedProgram];

    // Display images
    selectedImages.forEach(item => {
        const img = document.createElement("img");
        img.src = item.src;
        img.alt = item.name;
        img.dataset.name = item.name.toLowerCase(); // store name for search filtering

        img.addEventListener("click", () => {
            // Redirect to the corresponding HTML page
            window.location.href = item.page;
        });

        imageGallery.appendChild(img);
    });
}

function filterImages() {
    const searchBar = document.getElementById("searchBar").value.toLowerCase();
    const images = document.querySelectorAll("#imageGallery img");

    images.forEach(img => {
        const name = img.dataset.name;
        if (name.includes(searchBar)) {
            img.style.display = "inline"; // Show matching images
        } else {
            img.style.display = "none"; // Hide non-matching images
        }
    });
}
