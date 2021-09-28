import "./db";
import "./models/Video";
import express from "express";
import morgan from "morgan";
import globalRouter from "./routers/globalRouter";
import videoRouter from "./routers/videoRouter";
import userRouter from "./routers/userRouter";

const PORT = 4000;

const app = express();
// const logger = morgan("dev");

//application 설정 구간 -> application을 만들고, 외부 접속을 listen하는 사이에 작성해야 됨
//application에게 get request에 응답하는 방법 등등을 가르침
app.set("view engine", "pug");
app.set("views", process.cwd() + "/src/views");
// app.use(logger);
app.use(express.urlencoded({ extended: true }));
app.use("/", globalRouter);
app.use("/videos", videoRouter);
app.use("/users", userRouter);

const handleListening = () =>
  console.log(`✅ Server listening on port http://localhost:${PORT}`);

app.listen(PORT, handleListening);
