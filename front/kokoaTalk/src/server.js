import express from "express";
import rootRouter from "./routers/userRouter";

const app = express();

app.set("view engine", "pug");
app.set("views", process.cwd() + "/src/views");

app.use("/", rootRouter);

export default app;
