function deleteCourse(endpoint, courseId) {
    if (confirm("Bạn có chắc chắn muốn xóa khóa học này không?")) {
        fetch(endpoint + "/" + courseId, {
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


