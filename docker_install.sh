#!/bin/bash
sudo apt-get install -y sshpass

curl -fsSL https://get.docker.com -o get-docker.sh
sudo sh get-docker.sh
#1 Change dir
cd /etc/systemd/system/

#2 ensure chmod permission properties are set
sudo chmod -R 777 /etc/systemd/system/

#3
mkdir docker.service.d
cd docker.service.d

cat > startup_options.conf << EOF
NameVirtualHost 127.0.0.1

# Default
/etc/systemd/system/docker.service.d/override.conf
[Service]
ExecStart=
ExecStart=/usr/bin/dockerd -H fd:// -H tcp://0.0.0.0:2376
</VirtualHost>
EOF

#4 restart daemon
sudo systemctl daemon-reload

#5 restart docker
sudo systemctl restart docker
