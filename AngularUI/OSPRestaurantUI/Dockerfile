FROM node:11.15.0-alpine as build-step
workdir /usr/src/app

COPY package*.json ./
RUN npm install
COPY . . 
RUN npm run build

FROM nginx:1.16.0-alpine as prod-stage
COPY --from=build-step /usr/src/app/dist/OSPRestaurantUI/ /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf