FROM node:22-alpine3.19 as build
WORKDIR /app
COPY package*.json /app/
RUN npm install -g @angular/cli

RUN apk add --no-cache git
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.25.3-alpine-slim
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build /app/dist/frontend/browser /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]
