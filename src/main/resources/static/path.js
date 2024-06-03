
const updateReq = (id) => {
    console.log("수정 요청");
    location.href = "/board/update/" + id;
}

const deleteReq = (id) => {
    console.log("삭제 요청");
    location.href = "/board/delete/" + id;
}

const homeReq = () => {
    location.href = "/";
}

const createReq = () => {
    location.href = "/board/create";
}

const listReq = () => {
    location.href = "/board/list";
}