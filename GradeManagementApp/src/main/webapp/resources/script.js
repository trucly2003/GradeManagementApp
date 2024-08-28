function deleteCourse(endpoint, id) {
    if (confirm("Bạn có chắc chắn muốn xóa khóa học này không?") === true) {
        fetch(endpoint, {
            method: "DELETE"
        })
                .then(res => {
                    if (res.status === 204) {
                        let d = document.getElementById(`course${courseId}`);
                        d.style.display = "none";
                    } else {
                        alert("Không thể xóa khóa học. Vui lòng thử lại.");
                    }
                })
                .catch(error => {
                    console.error("Error:", error);
                    alert("Có lỗi xảy ra khi xóa khóa học.");
                });
    }
}

function deleteEnrollment(endpoint, id) {
    if (confirm("Bạn có chắc chắn muốn xóa đăng ký này không?")) {
        fetch(endpoint, {
            method: 'DELETE'
        })
                .then(response => {
                    if (response.status === 204) {
                        // Refresh the page to update the list
                        window.location.reload();
                    } else {
                        alert("Không thể xóa đăng ký. Vui lòng thử lại.");
                    }
                })
                .catch(error => {
                    console.error("Error:", error);
                    alert("Có lỗi xảy ra khi xóa đăng ký.");
                });
    }
}

