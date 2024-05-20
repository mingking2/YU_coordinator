
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

const saveReq = () => {
    location.href = "/board/save";
}

const listReq = () => {
    location.href = "/board/";
}

const pagingReq = () => {
    location.href = "/board/paging";
}