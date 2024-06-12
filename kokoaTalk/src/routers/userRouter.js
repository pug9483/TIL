import express from "express";
import { getLogin } from "../controllers/userController";

const userRouter = express.Router();

userRouter.get("/", getLogin);
export default userRouter;
