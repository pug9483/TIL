import express from "express";

const PORT = 4000;

const app = express();

//application 설정 구간 -> application을 만들고, 외부 접속을 listen하는 사이에 작성해야 됨
//application에게 get request에 응답하는 방법 등등을 가르침

const handleHome = (req, res) => {
    return res.send("/ page");
}

const handleLogin = (req, res) => {
    return res.send("Login here.");
}
app.get("/", handleHome);
app.get("/login", handleLogin)

const handleListening = () =>
 console.log(`Server listening on port http://localhost:${PORT}`);

app.listen(PORT, handleListening)